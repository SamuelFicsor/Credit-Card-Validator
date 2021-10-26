import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreditCardValidator
	{
		static long [] multiplied = new long [16];
		static int checkingNum = 0;
		static int validCount = 0;
		
		public static void cardValidatorDriver() throws IOException
			{
				Scanner file = new Scanner(new File("credit-card-numbers-real.txt"));
				
				while(file.hasNext())
					{
						digitStrip(file.nextLong());
						numChecker();
						checkingNum = 0;
						System.out.println("There are " + validCount + " possible valid card numbers.");
					}
			}
		
		
		public static void digitStrip(long l) throws IOException
			{
				for(int i = 15 ; i >= 0 ; i--)
					{
						multiplied[i] = l % 10;
						l /= 10;
						System.out.print(multiplied[i]);
					}
				System.out.println();
			}
		
		public static void numChecker() throws IOException
			{
				//while(file.hasNext())
				//{
					for(int i = 0 ; i < multiplied.length ; i ++)
						{
							if(i % 2 == 0)
								{
									multiplied[i] *= 2;
											
									 if(multiplied[i] * 2 > 9)
										{
											long firstNum = multiplied[i] % 10;
											long secondNum = multiplied[i] / 10;
											multiplied[i] = firstNum + secondNum;
										}
								}
							
						}
					
					for(int i = 0 ; i < multiplied.length ; i++)
						{
							System.out.print(multiplied[i]);
							checkingNum += multiplied[i];
						}
					
					System.out.println("\n" + checkingNum);
					
					if(checkingNum % 10 == 0)
						{
							System.out.println("Your credit card number may be valid.");
							validCount ++;
						}
					
					else
						{
							System.out.println("Your credit card number is invalid.");
						}
				//}
			}
	}
