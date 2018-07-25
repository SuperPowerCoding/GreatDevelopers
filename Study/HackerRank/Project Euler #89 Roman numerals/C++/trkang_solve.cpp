#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int get_roman_number_to_int(string &in)
{
    int number = 0;
    
    for(int i = 0; i < in.length(); ++i)
    {
        switch(in[i])
        {
            case 'M':
                number += 1000;
                break;
            case 'D':
                number += 500;
                break;
            case 'C':
                if (i+1 < in.length() && (in[i+1] == 'D' || in[i+1] == 'M'))
                {
                    number -= 100;
                }
                else
                {
                    number += 100;
                }
                break;
            case 'L':
                number += 50;
                break;
            case 'X':
                if (i+1 < in.length() && (in[i+1] == 'L' || in[i+1] == 'C'))
                {
                    number -= 10;
                }
                else
                {
                    number += 10;
                }
                break;
            case 'V':
                number += 5;
                break;
            case 'I':
                if (i+1 < in.length() && (in[i+1] == 'X' || in[i+1] == 'V'))
                {
                   number -= 1; 
                }
                else
                {
                   number += 1;
                }
                break;
            default:
                break;
        }
    }
    return number;
}

string get_int_to_roman_numstring(int number)
{
    string roman_numstr = "";
    int M_count = number / 1000;
    number = number - M_count * 1000;
    int C_count = number / 100;
    number = number - C_count * 100;
    int X_count = number / 10;
    int I_count = number - X_count * 10;
    
    for(int i = 0; i < M_count; ++i)
        roman_numstr.append("M");
    
    if (C_count == 4)
        roman_numstr.append("CD");
    else if (C_count == 9)
        roman_numstr.append("CM");
    else 
    {
        if (C_count >= 5)
        {
            roman_numstr.append("D");
            C_count -= 5;
        }
        for(int i = 0; i < C_count; ++i)
            roman_numstr.append("C");
    }
    
    if (X_count == 4)
        roman_numstr.append("XL");
    else if (X_count == 9)
        roman_numstr.append("XC");
    else 
    {
        if (X_count >= 5)
        {
            roman_numstr.append("L");
            X_count -= 5;
        }
        for(int i = 0; i < X_count; ++i)
            roman_numstr.append("X");
    }

    if (I_count == 4)
        roman_numstr.append("IV");
    else if (I_count == 9)
        roman_numstr.append("IX");
    else 
    {
        if (I_count >= 5)
        {
            roman_numstr.append("V");
            I_count -= 5;
        }
        for(int i = 0; i < I_count; ++i)
            roman_numstr.append("I");
    }    
    
    return roman_numstr;
}

string convert_mininum_length_roman_numbers(string &in)
{
    int number = get_roman_number_to_int(in);
    return get_int_to_roman_numstring(number);
}


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for(int idx = 0; idx < n; ++idx)
    {
        string roman_input;
        string roman_converted;
        getline(cin, roman_input);

        roman_converted = convert_mininum_length_roman_numbers(roman_input);
        cout << roman_converted << endl;
    }

    return 0;
}
