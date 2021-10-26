
public class CreditCardMaker
	{

		static long [] creditCardNum = new long[16];
		
		public static long [] creditCardMakerDriver()
		{
					for(int i = 0; i < 16 ; i++)
					{
						long randomNum = (int) (Math.random()*10);
						creditCardNum[i] = randomNum;
						makerValidator.multiplied[i] = randomNum;
					}
					
					return makerValidator.multiplied;
		}
		
	}
