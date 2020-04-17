//Steven Zuelke
//Minesweeper Main
/*
 Team Members: Cody Bafus, Austin Hall
 This class takes in a minefield and outputs with all hints given
*/

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Minesweeper
{
    class Startup
    {
        static char[,] Field;
        static string Output = "";
        static int FieldNumber = 0;
        
        public static void Main(string[] args)
        {

            int n = -1, m = -1;
            string input;
            string numberStr = "";
            

            while(!(n == 0 && m == 0))
            {

                //Read dimensions
                input = Console.ReadLine();
                for(int i = 0; i < input.Length; i++)
                {

                    if (Char.IsDigit(input[i]))
                    {

                        numberStr += input[i];

                    }else if(input[i] == ' ')//end number if
                    {

                        n = int.Parse(numberStr);
                        numberStr = "";

                    }//end space if
                    if(i == input.Length-1)
                    {

                        m = int.Parse(numberStr);
                        numberStr = "";

                    }//end the endcase if

                }//end for loop i
                //if both are 0 then exit
                if (!(n == 0 && m == 0))
                {

                    FieldNumber++;
                    //Fill in the current field
                    Field = new char[n, m];
                    for (int i = 0; i < n; i++)
                    {

                        input = Console.ReadLine();
                        for (int j = 0; j < m; j++)
                        {

                            Field[i, j] = input[j];

                        }//end for loop j

                    }//end for loop i
                     //Call methods to Fill in new field and add to output.
                    Calculate();
                    PrintQueue();

                } 

            }//end while n & m = 0
            //Print all the fields
            Console.Write(Output);
            //Wait so client can read output
            Console.ReadLine();

        }//end Main
    
        //Method to change all '.' to the correct number
        
        static private void Calculate()
        {

            char q;
            for(int i = 0; i < Field.GetLength(0); i++)
            {

                for(int j = 0; j < Field.GetLength(1); j++)
                {

                    if(Field[i, j] == '.')
                    {

                        Field[i, j] = CheckPerim(i, j).ToString()[0];

                    }//end if

                }//end for j

            }//end for i

        }

        //Method to get the number for certain index
        static private int CheckPerim(int r, int c)
        {

            int mineCount = 0;

            for(int i = r - 1; i <= r + 1; i++)
            {

                for(int j = c - 1; j <= c + 1; j++)
                {

                    if(i >= 0 && j >= 0 && i < Field.GetLength(0) && j < Field.GetLength(1))
                    {

                        if (Field[i, j] == '*') mineCount++;

                    }

                }//end for j

            }//end for i
            return mineCount;

        }

        //Method to add the field to the output

        static private void PrintQueue()
        {

            Output += "Field: " + FieldNumber + "\n";
            for(int i = 0; i < Field.GetLength(0); i++)
            {

                for(int j = 0; j < Field.GetLength(1); j++)
                {

                    Output += Field[i, j].ToString();

                }//end for j
                Output += "\n";

            }//end for i

        }

    }

}
