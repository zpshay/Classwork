package main
import (
    "bufio"
    "fmt"
    "log"
    "os"
    "strings"
)

var (
	inFile = "fab.in"
	outFile = "fab.out"
	max_rows = 21
	max_cols = 19
	alignL = byte('<')
	alignR = byte('>')
	alignC = byte('=')
	l_type = 0 //0 Header; 1 Row; 2 End of File;
	rows = 0
	columns = 0
	sline = ""
	c_sline = ""
	max_width [19]int 
	data = make([]string, max_rows*max_cols)
	width = make([]int, max_rows*max_cols)
	currentrow = 0
	crow = 0
	wordsread = 0
	realwidth = make([]int,max_rows*max_cols)
)

func main() {
	createFile(outFile)
	file, err := os.Open(inFile)
    if err != nil {
        log.Fatal(err)
    }

  writefile, error := os.OpenFile(outFile, os.O_APPEND|os.O_WRONLY, 0600)
	if error != nil {
		fmt.Println(error)
	   return
	}
  scanner := bufio.NewScanner(file)
  //for scanner.Scan() {
	/*reader := bufio.NewReader(os.Stdin)
	fmt.Print("Enter File Name: ")
	inFile, _ := reader.ReadString('\n')
	inFile = inFile[0:len(inFile)-2]
	fmt.Println(inFile)
	fmt.Print("Enter File Name: ")
	outFile, _ := reader.ReadString('\n')
	outFile = outFile[0:len(outFile)-2] 
	fmt.Println("'" + outFile + "'")*/
	readLines(scanner)
	for l_type != 2 {
		consume_header()
		readLines(scanner)
		read_row(scanner)
		print_sep("@","-",writefile)
		fmt.Fprintf(writefile, "\n")
		fmt.Println()
		print_row(crow,writefile)
		fmt.Fprintf(writefile, "\n")
		fmt.Println()
		print_sep("|","+",writefile)

		for row_count := 0; row_count < rows-1; row_count++ {
			fmt.Fprintf(writefile, "\n")
			fmt.Println()
			print_row(crow,writefile)
		}
		fmt.Fprintf(writefile, "\n")
		fmt.Println()
		print_sep("@","-",writefile)
		fmt.Fprintf(writefile, "\n")
		fmt.Println()
	}
	file.Close()
	writefile.Close()
}

func consume_header() {
	columns = len(sline)
	c_sline = sline

	for c := 0; c < columns; c++ {
		max_width[c] = 0;
	}
}

func read_row(scanner *bufio.Scanner) {
	rows = 0
	for l_type == 1 {
		splitline := strings.Split(sline, "&")
		for i:=0; i<strings.Count(sline, "&")+1; i++ {
			data[currentrow + i] = splitline[i]
			width[currentrow + i] = len(splitline[i])
			wordsread = wordsread + 1
			if len(splitline[i]) > max_width[i] {
				max_width[i] = len(splitline[i])
			}
		}
		for p:=0; p<wordsread; p++ {
			realwidth[p] = width[p]
		}
		currentrow = currentrow + columns
		rows++
		readLines(scanner)
	}
}

func print_sep(outcorner string, border string, writing *os.File) {
	print_char(outcorner, 1,writing)
	print_char("-",max_width[0] + 1,writing)
	for c:=1; c < columns; c++ {
		print_char(border,1,writing)
		print_char("-",max_width[c]+1,writing)
	}
	print_char(outcorner,1,writing)
}

func print_row(r int, writing *os.File) {
	for clm := 0; clm < columns; clm++ {
		n := realwidth[r+clm]
		pad := max_width[clm] - n
		fmt.Fprintf(writing, "| ")
		fmt.Print("| ")
		if string(c_sline[clm]) == "<" {
			fmt.Fprintf(writing, data[crow+clm])
			fmt.Print(data[crow+clm])
			print_char(" ", pad,writing)
		} else if string(c_sline[clm]) == ">" {
			print_char(" ", pad,writing)
			fmt.Fprintf(writing, data[crow+clm])
			fmt.Print(data[crow+clm])
		} else if string(c_sline[clm]) == "=" {
			print_char(" ", pad/2,writing)
			fmt.Fprintf(writing, data[crow+clm])
			fmt.Print(data[crow+clm])
			print_char(" ", pad - (pad/2),writing)
		}
	}
	crow = crow + columns
	fmt.Fprintf(writing, "|")
	fmt.Print("|")
}

func print_char (picture string, numberpics int, writing *os.File) {
	for i:=0; i<numberpics; i++ { 
		fmt.Fprintf(writing, picture)
		fmt.Print(picture) 
	}
}

func createFile(outpath string) {
	writefile, err := os.Create(outpath)
	fmt.Println("Created File: " + outpath)
	if err != nil {
		fmt.Println(err)
	   return
	}
	writefile.Close()
}

func readLines(scanner *bufio.Scanner) {
		scanner.Scan()
    line := scanner.Text()
    sline = string(line)
    if sline[0] == '*' {
    	l_type = 2;
    } else if sline[0] == alignL || sline[0] == alignR || sline[0] == alignC {
    	l_type = 0
    } else {
    	l_type = 1
    }
    //writeLines(line, outpath)
    //}

    if err := scanner.Err(); err != nil {
        log.Fatal(err)
    }
    return
}
