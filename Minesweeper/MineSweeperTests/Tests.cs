//Steven Zuelke (Author)
//Class to test the main (call calculate method)
//Revision 1
//Team members Austin Hall, Cody Bafus, Steven Zuelke

using Microsoft.VisualStudio.TestTools.UnitTesting;
using Minesweeper;

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
            char[,] fieldOut;

            fieldIn[0, 0] = '.';
            //Act
            fieldOut = Startup.Calculate(fieldIn);
            //Assert
            Assert.AreEqual<int>(fieldIn.GetLength(0), fieldOut.GetLength(0));
            Assert.AreEqual<int>(fieldIn.GetLength(1), fieldOut.GetLength(1));
            Assert.AreEqual<char>('0', fieldOut[0, 0]);

        }

        [TestMethod]
        public void OneByOne_YesMine()
        {

            //Arrange
            char[,] fieldIn = new char[1, 1];
            char[,] fieldOut;

            fieldIn[0, 0] = '*';
            //Act
            fieldOut = Startup.Calculate(fieldIn);
            //Assert
            Assert.AreEqual<int>(fieldIn.GetLength(0), fieldOut.GetLength(0));
            Assert.AreEqual<int>(fieldIn.GetLength(1), fieldOut.GetLength(1));
            Assert.AreEqual<char>('*', fieldOut[0, 0]);

        }

        [TestMethod]
        public void OneByHundred_NoMine()
        {

            //Arrange
            char[,] fieldIn = new char[1, 100];
            char[,] fieldOut;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                   fieldIn[i, j] = '.'; 

                }//end for j

            }//end for i

            //Act
            fieldOut = Startup.Calculate(fieldIn);
            //Assert
            Assert.AreEqual<int>(fieldIn.GetLength(0), fieldOut.GetLength(0));
            Assert.AreEqual<int>(fieldIn.GetLength(1), fieldOut.GetLength(1));
            for (int i = 0; i < fieldOut.GetLength(0); i++)
            {

                for (int j = 0; j < fieldOut.GetLength(1); j++)
                {

                    Assert.AreEqual<char>('0', fieldOut[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void OneByHundred_AllMines()
        {

            //Arrange
            char[,] fieldIn = new char[1, 100];
            char[,] fieldOut;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Act
            fieldOut = Startup.Calculate(fieldIn);
            //Assert
            Assert.AreEqual<int>(fieldIn.GetLength(0), fieldOut.GetLength(0));
            Assert.AreEqual<int>(fieldIn.GetLength(1), fieldOut.GetLength(1));
            for (int i = 0; i < fieldOut.GetLength(0); i++)
            {

                for (int j = 0; j < fieldOut.GetLength(1); j++)
                {

                    Assert.AreEqual<char>('*', fieldOut[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void OneByHundred_HalfMine()
        {

            //Arrange
            char[,] fieldIn = new char[1, 100];
            char[,] fieldOut;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    if (j <= 50) fieldIn[i, j] = '.';
                    else fieldIn[i, j] = '*';

                }//end for j

            }//end for i
            //Read Board from file to confirm

            //Act
            fieldOut = Startup.Calculate(fieldIn);
            //Assert
            Assert.AreEqual<int>(fieldIn.GetLength(0), fieldOut.GetLength(0));
            Assert.AreEqual<int>(fieldIn.GetLength(1), fieldOut.GetLength(1));
            // Assert.AreEqual
            for (int i = 0; i < fieldOut.GetLength(0); i++)
            {

                for (int j = 0; j < fieldOut.GetLength(1); j++)
                {

                    if (j <= 50) ;// Assert.AreEqual<char>();
                    else Assert.AreEqual<char>('*', fieldOut[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void HundredByHundred_NoMine()
        {

            //Arrange
            char[,] fieldIn = new char[100, 100];
            char[,] fieldOut;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    fieldIn[i, j] = '.';

                }//end for j

            }//end for i

            //Act
            fieldOut = Startup.Calculate(fieldIn);
            //Assert
            Assert.AreEqual<int>(fieldIn.GetLength(0), fieldOut.GetLength(0));
            Assert.AreEqual<int>(fieldIn.GetLength(1), fieldOut.GetLength(1));
            for (int i = 0; i < fieldOut.GetLength(0); i++)
            {

                for (int j = 0; j < fieldOut.GetLength(1); j++)
                {

                    Assert.AreEqual<char>('0', fieldOut[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void HundredByHundred_AllMine()
        {

            //Arrange
            char[,] fieldIn = new char[100, 100];
            char[,] fieldOut;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Act
            fieldOut = Startup.Calculate(fieldIn);
            //Assert
            Assert.AreEqual<int>(fieldIn.GetLength(0), fieldOut.GetLength(0));
            Assert.AreEqual<int>(fieldIn.GetLength(1), fieldOut.GetLength(1));
            for (int i = 0; i < fieldOut.GetLength(0); i++)
            {

                for (int j = 0; j < fieldOut.GetLength(1); j++)
                {

                    Assert.AreEqual<char>('*', fieldOut[i, j]);

                }//end for j

            }//end for i

        }

        [TestMethod]
        public void HundredByHundred_HalfMine()
        {

            //Arrange
            char[,] fieldIn = new char[100, 100];
            char[,] fieldOut;
            
            for(int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++) 
                {

                    if ((i % 2) == 0) fieldIn[i, j] = '.';
                    else fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Act
            fieldOut = Startup.Calculate(fieldIn);
            //Assert
            Assert.AreEqual<int>(fieldIn.GetLength(0), fieldOut.GetLength(0));
            Assert.AreEqual<int>(fieldIn.GetLength(1), fieldOut.GetLength(1));
            // Assert.AreEqual
            for (int i = 0; i < fieldOut.GetLength(0); i++)
            {

                for (int j = 0; j < fieldOut.GetLength(1); j++)
                {

                    if ((i % 2) == 0) ;// fieldIn[i, j] = '.';
                    else Assert.AreEqual<char>('*', fieldOut[i, j]);

                }//end for j

            }//end for i

        }

        //Extra Test 50x100 Field half full of mines
        [TestMethod]
        public void FiftyByHundred_HalfMine()
        {

            //Arrange
            char[,] fieldIn = new char[50, 100];
            char[,] fieldOut;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    if ((i % 2) == 0) fieldIn[i, j] = '.';
                    else fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Act
            fieldOut = Startup.Calculate(fieldIn);
            //Assert
            Assert.AreEqual<int>(fieldIn.GetLength(0), fieldOut.GetLength(0));
            Assert.AreEqual<int>(fieldIn.GetLength(1), fieldOut.GetLength(1));
            // Assert.AreEqual
            for (int i = 0; i < fieldOut.GetLength(0); i++)
            {

                for (int j = 0; j < fieldOut.GetLength(1); j++)
                {

                    if ((i % 2) == 0) ;// fieldIn[i, j] = '.';
                    else Assert.AreEqual<char>('*', fieldOut[i, j]);

                }//end for j

            }//end for i

        }

        //Extra Test 50x100 Quarter Mines
        [TestMethod]
        public void FiftyByHundred_QuarterMine()
        {

            //Arrange
            char[,] fieldIn = new char[100, 100];
            char[,] fieldOut;

            for (int i = 0; i < fieldIn.GetLength(0); i++)
            {

                for (int j = 0; j < fieldIn.GetLength(1); j++)
                {

                    if ((i % 4) == 0) fieldIn[i, j] = '.';
                    else fieldIn[i, j] = '*';

                }//end for j

            }//end for i

            //Act
            fieldOut = Startup.Calculate(fieldIn);
            //Assert
            Assert.AreEqual<int>(fieldIn.GetLength(0), fieldOut.GetLength(0));
            Assert.AreEqual<int>(fieldIn.GetLength(1), fieldOut.GetLength(1));
            // Assert.AreEqual
            for (int i = 0; i < fieldOut.GetLength(0); i++)
            {

                for (int j = 0; j < fieldOut.GetLength(1); j++)
                {

                    if ((i % 2) == 0) ;// fieldIn[i, j] = '.';
                    else Assert.AreEqual<char>('*', fieldOut[i, j]);

                }//end for j

            }//end for i

        }

    }

}
