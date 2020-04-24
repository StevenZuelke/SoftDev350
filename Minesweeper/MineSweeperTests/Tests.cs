//Steven Zuelke (Author)
//Class to test the main (call calculate method)
//Revision 1
//Team members Austin Hall, Cody Bafus, Steven Zuelke

using Microsoft.VisualStudio.TestTools.UnitTesting;
using Minesweeper;
using System.IO;

namespace MineSweeperTests
{
    [TestClass]
    public class Tests
    {


        [TestMethod]
        public void OneByOne_NoMine()
        {

            //Arrange
            char[,] fieldIn = new char[1, 1];

            fieldIn[0, 0] = '.';
            //Act
            Startup.Calculate(fieldIn);
            //Assert
            Assert.AreEqual<char>('0', fieldIn[0, 0]);

        }

        [TestMethod]
        public void OneByOne_YesMine()
        {

            //Arrange
            char[,] fieldIn = new char[1, 1];

            fieldIn[0, 0] = '*';
            //Act
            fieldIn = Startup.Calculate(fieldIn);
            //Assert
            Assert.AreEqual<char>('*', fieldIn[0, 0]);

        }

        [TestMethod]
        public void OneByHundred_NoMine()
        {

            //Arrange
            char[,] fieldIn = new char[1, 100];

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                   fieldIn[i, j] = '.'; 

                }//end for j

            }//end for i

            //Act
            Startup.Calculate(fieldIn);
            //Assert
            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    Assert.AreEqual<char>('0', fieldIn[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void OneByHundred_AllMines()
        {

            //Arrange
            char[,] fieldIn = new char[1, 100];

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Act
            Startup.Calculate(fieldIn);
            //Assert
            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    Assert.AreEqual<char>('*', fieldIn[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void OneByHundred_HalfMine()
        {

            //Arrange
            char[,] fieldIn = new char[1, 100];
            char[,] fieldFile = new char[1, 100];
            string[] fileLines;
            char[] currentLine;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    if (j <= 49) fieldIn[i, j] = '.';
                    else fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Read Board from file to confirm
            fileLines = File.ReadAllLines("1x100.txt");
            for(int i = 0; i < fileLines.Length; i++)
            {

                currentLine = fileLines[i].ToCharArray();
                for (int j = 0; j < currentLine.Length; j++)
                {

                    fieldFile[i, j] = currentLine[j];

                }//end for j

            }//end for i
            //Act
            Startup.Calculate(fieldIn);
            //Assert
            //Confirm the output is the same as confirmed field in the text file
            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    Assert.AreEqual<char>(fieldFile[i, j], fieldIn[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void HundredByHundred_NoMine()
        {

            //Arrange
            char[,] fieldIn = new char[100, 100];

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    fieldIn[i, j] = '.';

                }//end for j

            }//end for i

            //Act
            Startup.Calculate(fieldIn);
            //Assert
            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    Assert.AreEqual<char>('0', fieldIn[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void HundredByHundred_AllMine()
        {

            //Arrange
            char[,] fieldIn = new char[100, 100];

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Act
            Startup.Calculate(fieldIn);
            //Assert
            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    Assert.AreEqual<char>('*', fieldIn[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void HundredByHundred_HalfMine()
        {

            //Arrange
            char[,] fieldIn = new char[100, 100];
            char[,] fieldFile = new char[100, 100];
            string[] fileLines;
            char[] currentLine;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++) 
                {

                    if ((i % 2) == 0) fieldIn[i, j] = '.';
                    else fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Read Board from file to confirm
            fileLines = File.ReadAllLines("100x100.txt");
            for (int i = 0; i < fileLines.Length; i++)
            {

                currentLine = fileLines[i].ToCharArray();
                for (int j = 0; j < currentLine.Length; j++)
                {

                    fieldFile[i, j] = currentLine[j];

                }//end for j

            }//end for i
            //Act
            Startup.Calculate(fieldIn);
            //Assert
            //Confirm the output is the same as confirmed field in the text file
            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    Assert.AreEqual<char>(fieldFile[i, j], fieldIn[i, j]);

                }//end for j

            }//end for i

        }

        //Extra Test 50x100 Field half full of mines
        [TestMethod]
        public void FiftyByHundred_HalfMine()
        {

            //Arrange
            char[,] fieldIn = new char[50, 100];
            char[,] fieldFile = new char[50, 100];
            string[] fileLines;
            char[] currentLine;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    if ((i % 2) == 0) fieldIn[i, j] = '.';
                    else fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Read Board from file to confirm
            fileLines = File.ReadAllLines("50x100half.txt");
            for (int i = 0; i < fileLines.Length; i++)
            {

                currentLine = fileLines[i].ToCharArray();
                for (int j = 0; j < currentLine.Length; j++)
                {

                    fieldFile[i, j] = currentLine[j];

                }//end for j

            }//end for i
            //Act
            Startup.Calculate(fieldIn);
            //Assert
            //Confirm the output is the same as confirmed field in the text file
            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    Assert.AreEqual<char>(fieldFile[i, j], fieldIn[i, j]);

                }//end for j

            }//end for i

        }

        //Extra Test 50x100 Quarter Mines
        [TestMethod]
        public void FiftyByHundred_QuarterMine()
        {

            //Arrange
            char[,] fieldIn = new char[50, 100];
            char[,] fieldFile = new char[50, 100];
            string[] fileLines;
            char[] currentLine;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    if ((i % 4) == 0) fieldIn[i, j] = '.';
                    else fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Read Board from file to confirm
            fileLines = File.ReadAllLines("50x100quarter.txt");
            for (int i = 0; i < fileLines.Length; i++)
            {

                currentLine = fileLines[i].ToCharArray();
                for (int j = 0; j < currentLine.Length; j++)
                {

                    fieldFile[i, j] = currentLine[j];

                }//end for j

            }//end for i
            //Act
            Startup.Calculate(fieldIn);
            //Assert
            //Confirm the output is the same as confirmed field in the text file
            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    Assert.AreEqual<char>(fieldFile[i, j], fieldIn[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void HundredByOne_AllMines()
        {

            //Arrange
            char[,] fieldIn = new char[100, 1];

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Act
            Startup.Calculate(fieldIn);
            //Assert
            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    Assert.AreEqual<char>('*', fieldIn[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void HundredByOne_NoMine()
        {

            //Arrange
            char[,] fieldIn = new char[100, 1];

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    fieldIn[i, j] = '.';

                }//end for j

            }//end for i

            //Act
            Startup.Calculate(fieldIn);
            //Assert
            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    Assert.AreEqual<char>('0', fieldIn[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void HundredByOne_HalfMine()
        {

            //Arrange
            char[,] fieldIn = new char[100, 1];
            char[,] fieldFile = new char[100, 1];
            string[] fileLines;
            char[] currentLine;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    if (i <= 49) fieldIn[i, j] = '.';
                    else fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Read Board from file to confirm
            fileLines = File.ReadAllLines("100x1.txt");
            for (int i = 0; i < fileLines.Length; i++)
            {

                currentLine = fileLines[i].ToCharArray();
                for (int j = 0; j < currentLine.Length; j++)
                {

                    fieldFile[i, j] = currentLine[j];

                }//end for j

            }//end for i
            //Act
            Startup.Calculate(fieldIn);
            //Assert
            //Confirm the output is the same as confirmed field in the text file
            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    Assert.AreEqual<char>(fieldFile[i, j], fieldIn[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void FiveByFive_MineEveryTwoSpacesPerLine()
        {

            //Arrange
            char[,] fieldIn = new char[5, 5];
            char[,] fieldFile = new char[5, 5];
            string[] fileLines;
            char[] currentLine;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    if (j % 2 == 0) fieldIn[i, j] = '.';
                    else fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Read Board from file to confirm
            fileLines = File.ReadAllLines("5x5.txt");
            for (int i = 0; i < fileLines.Length; i++)
            {

                currentLine = fileLines[i].ToCharArray();
                for (int j = 0; j < currentLine.Length; j++)
                {

                    fieldFile[i, j] = currentLine[j];

                }//end for j

            }//end for i
            //Act
            Startup.Calculate(fieldIn);
            //Assert
            //Confirm the output is the same as confirmed field in the text file
            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    Assert.AreEqual<char>(fieldFile[i, j], fieldIn[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void TenByEleven_MineAfterEverySafeSpace()
        {

            //Arrange
            char[,] fieldIn = new char[10, 11];
            char[,] fieldFile = new char[10, 11];
            string[] fileLines;
            char[] currentLine;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    if ((i % 2 == 0 && j % 2 == 0) || i % 2 == 1 && j % 2 == 1) fieldIn[i, j] = '.';
                    else fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Read Board from file to confirm
            fileLines = File.ReadAllLines("11x10.txt");
            for (int i = 0; i < fileLines.Length; i++)
            {

                currentLine = fileLines[i].ToCharArray();
                for (int j = 0; j < currentLine.Length; j++)
                {

                    fieldFile[i, j] = currentLine[j];

                }//end for j

            }//end for i
            //Act
            Startup.Calculate(fieldIn);
            //Assert
            //Confirm the output is the same as confirmed field in the text file
            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    Assert.AreEqual<char>(fieldFile[i, j], fieldIn[i, j]);

                }//end for j

            }//end for i

        }
    }

}
