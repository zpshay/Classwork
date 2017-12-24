# COMP 3200 -- NFA-based string acceptor
# Zach Shay - Nov. 2, 2012

from __future__ import print_function


char_codes = {'a':1, 'b':2}

M = [{'':{1}, 'a':{2}},
		 {'':{2}},
		 {'b':{1,3}},
		 {'a':{1,3}}]

A = {1,3}

def nfa_eclosure(M,s):
	for c in s:
		state = 
	return
def nfa_accepts(M, A, x):

	return rejacc

if __name__ == '__main__':
  while True:
    try:
       s = raw_input('--> ')
    except EOFError:
       break

    if trace_accept(s):         # use accept or trace_accept
      print('\taccept')
    else:
       print('\treject')