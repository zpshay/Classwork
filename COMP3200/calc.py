# CSC 3200 -- Spring 2012 - Recursive-descent calculator

from __future__ import division, print_function

import re

# --- lexer (lexical analyzer, or scanner) ---

class Lexer:
    ignore = re.compile(r'[ \t]+')

    rules = [
        (re.compile(r'[0-9]+'),     lambda s: int(s)),
        (re.compile(r'[a-zA-Z]+'),  lambda s: s),
        (re.compile(r'[?=:|&!<>@+\-*/^()%]'), lambda s: s),
        (re.compile(r'.'),          lambda s: '#' + str(ord(s))),
        ]


    def __init__(self, input_string):
        self.s = input_string
        self.pos = 0


    def next(self):
        # skip over ignorable characters
        m = self.ignore.match(self.s, self.pos)
        if m: self.pos = m.end()

        if self.pos >= len(self.s):
            return '$'      # denotes end of input

        for rule in self.rules:
            r, f = rule
            m = r.match(self.s, self.pos)
            if m:
                self.pos = m.end()
                return f(m.group())


# --- parse error exception ---

class ParseError(Exception):
    def __init__(self, message):
        self.message = message


# --- parser (syntax analyzer): returns an AST ---

class Parser:
    def __init__(self, input_string):
        self.lexer = Lexer(input_string)
        self.next()


    def error(self, message):
        raise ParseError(message + ' [next token: ' + str(self.tok) + ']')


    def next(self):
        self.tok = self.lexer.next()


    def parse(self):
        """ input : expr '$' """

        e = self.parse_expr()
        if self.tok == '$':
            return e
        else:
            self.error('extraneous input')

    def parse_expr(self):
        """ expr ::= {(=) cond_expr} """

        e = self.parse_cond()
        if self.tok == ('='):
            t = self.tok
            e = (t, e, self.parse_cond())
        return e
        

    def parse_cond(self):
        """ cond ::= or_expr {(?) or_expr (:) or_expr} """

        e = self.parse_or()
        while self.tok in ('?'):
            t = self.tok
            self.next()
            g = self.parse_or()
            while self.tok in (':'):
                self.next()
                e = (t, e, g, self.parse_or())
        return e 
        

    def parse_or(self):
        """ or_expr ::= and_expr {(|) and_expr} """

        e = self.parse_and()
        while self.tok in ('|'):
            t = self.tok
            self.next()
            e = (t, e, self.parse_and())
        return e

    def parse_and(self):
        """ and_expr ::= not_expr {(&) not_expr} """

        e = self.parse_not()
        while self.tok in ('&'):
            t = self.tok
            self.next()
            e = (t, e, self.parse_not())
        return e

    def parse_not(self):
        """ not_expr ::= ! ifelse """

        if self.tok == '!':
            self.next()
            return ('!', self.parse_ifelse())
        else:
            return self.parse_ifelse()
       
    def parse_ifelse(self):
        """ ifelse ::= arith_expr {(< | > | <= | >= | != | ==) arith_expr} """

        e = self.parse_arith()
        while self.tok in ('<', '>', '!', '='):
            t = self.tok
            self.next()
            if self.tok == '=':
                while self.tok in ('='):
                    t = t + self.tok
                    self.next()
                    e = (t, e, self.parse_arith())
            else:
                e = (t, e, self.parse_arith())
        return e
        
        
    def parse_arith(self):
        """ arith ::= mul_expr {(+|-) mul_expr} """

        e = self.parse_mul()
        while self.tok in ('+', '-'):
            t = self.tok      # remember operator
            self.next()
            e = (t, e, self.parse_mul())
        return e


    def parse_mul(self):
        """ mul_expr ::= neg_expr {(*|/|%) neg_xpr} """

        e = self.parse_neg()
        while self.tok in ('*', '/','%'):
            t = self.tok
            self.next()
            e = (t, e, self.parse_neg())
        return e


    def parse_neg(self):
        """ neg_expr ::= - neg_expr | @ neg_expr | pow_expr """

        if self.tok == '-':
            self.next()
            return ('neg', self.parse_neg())
        elif self.tok == '@':
            self.next()
            return ('ab', self.parse_neg())
        else:
            return self.parse_pow()
    
    def parse_pow(self):
        """ pow_expr ::= factor [^ pow_expr] """

        e = self.parse_factor()
        if self.tok == '^':
            self.next()
            e = ('^', e, self.parse_pow())
        return e


    def parse_factor(self):
        """ factor ::= int | id | '(' expr ')' """

        if isinstance(self.tok, int):
            n = self.tok
            self.next()
            return n
        elif self.tok.isalpha():
            var = self.tok
            self.next()
            return var
        elif self.tok == '(':
            self.next()
            e = self.parse_expr()
            if self.tok != ')':
                self.error('missing )')
            else:
                self.next()
            return e
        else:
            self.error("expected int or '('")

   
    


# --- postorder AST walker ---

VARS = {}   # dictionary of variables

def assign(v, value):
    # assignment is a statement in Python that 'returns' None;
    # this can be used as an expression, returning the value assigned
    VARS[v] = value
    return value

eval_op = {
    '='  : lambda x,y: assign(x, eval(y)),
    '?'  : lambda x,y,z: eval(y) if (eval(x) != 0) else eval(z),
    '|'  : lambda x,y: eval(y) if (eval(x) == 0) else x,
    '&'  : lambda x,y: 0 if (eval(x) == 0) else eval(y),
    '!'  : lambda x: 1 if (eval(x) == 0) else 0,
    '<'  : lambda x,y: 1 if (eval(x) < eval(y)) else 0,
    '>'  : lambda x,y: 1 if (eval(x) > eval(y)) else 0,
    '<='  : lambda x,y: 1 if (eval(x) <= eval(y)) else 0,
    '>='  : lambda x,y: 1 if (eval(x) >= eval(y)) else 0,
    '!='  : lambda x,y: 1 if (eval(x) != eval(y)) else 0,
    '=='  : lambda x,y: 1 if (eval(x) == eval(y)) else 0,
    '+'  : lambda x,y: eval(x) + eval(y),
    '-'  : lambda x,y: eval(x) - eval(y),
    '*'  : lambda x,y: eval(x) * eval(y),
    '/'  : lambda x,y: eval(x) // eval(y),
    '^'  : lambda x,y: eval(x) ** eval(y),
    '%'  : lambda x,y: eval(x) % eval(y),
    'neg': lambda x: -eval(x),
    'ab'  : lambda x: abs(eval(x))
    }

def eval(e):
    if isinstance(e, int):
        return e
    elif isinstance(e, str):
        return VARS.get(e, 0)
    else:
        return eval_op[e[0]](*e[1:])


# --- main calculator function ---

def calc(line):
    return eval(Parser(line).parse())


# --- scaffolding for interactive testing ---

if __name__ == '__main__':
    while True:
        try:
            
            line = raw_input('Enter file names separated by commas: ')
            files = [x.strip() for x in line.split(',') if x != '']
        except EOFError:
            break

        if line == '' or line.isspace(): break

        try:
            for filename in files:
                with open(filename, "r") as file_in:
                    for x in file_in:
                        x = x.rstrip("\n")
                        e = Parser(x).parse()
                        print('\tAST:', e)
                        print(eval(e))
        except ParseError as err:
            print('parse error:', err.message)
