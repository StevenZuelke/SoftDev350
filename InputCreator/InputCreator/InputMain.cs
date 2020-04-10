//Steven Zuelke
//InputCreator

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InputCreator
{
    class InputMain
    {
        public static void Main(string[] args)
        {
            FileStream fileStream;
            IList<string> text = new List<string>();
            string finalText = "";
            UnicodeEncoding encoder = new UnicodeEncoding();
            byte[] output;

            fileStream = File.Create("inputFile.txt");
            
            //Hardcode example cases
            text.Add("4 4"); 
            text.Add("*...");
            text.Add("....");
            text.Add(".*..");
            text.Add("....");
            text.Add("3 5");
            text.Add("**...");
            text.Add(".....");
            text.Add(".*...");

            //Hardcode edge cases
            //Minimum size cases
            text.Add("1 1");
            text.Add(".");
            text.Add("1 1");
            text.Add("*");

            //Maximum size cases
            //All bombs
            text.Add("100 100");
            for (int i = 0; i < 100; i++)
            {
                text.Add(item: MaxLine('*'));
            }
            //No bombs
            text.Add("100 100");
            for (int i = 0; i < 100; i++)
            {
                text.Add(item: MaxLine('.'));
            }
            //Some bombs
            text.Add("100 100");
            for (int i = 0; i < 50; i++)
            {
                text.Add(item: MaxLine('.'));
                text.Add(item: MaxSome());
            }
            foreach (string line in text)
            {
                finalText += line + "\n";
            }

            //Convert to bytes
            output = encoder.GetBytes(finalText);
            fileStream.Write(output, 0, output.Length);

            //Close FileStream
            fileStream.Close();
        }//End main

        //Method to fill a line of 100 chars (c)

        private static string MaxLine(char c)
        {
            string line = "";
            for (int i = 0; i < 100; i++)
            {
                line += c;
            }
            return line;
        }

        //Method to fill a line with every other . or *

        private static string MaxSome()
        {
            string line = "";
            for (int i = 0; i < 25; i++)
            {
                line += ".*..";
            }
            return line;
        }

    }
}
