import java.util.regex.*;
class main
{
	public static void main(String args[])
	{

		String longString = " Derek Banas CA 12345 PA (412)555-1212 johnsmith@hotmail.com 412-555-1234 412 555-1234 "; 
		String strangeString = " 1Z aaa **** *** {{{ {{ { ";
		//	[A-Z] - to get Any uppercase character from A to Z.
		//	[a-z] - to get Any lowercase chracter from a to z.
		//	[A-Za-z] - to get Any uppercase or lowercase character from A-Z or a-z
		//	[0-9]	- to get any character from 0 to 9.
		//	[^A-F] - to not get any character from A to F.
		//	\\s	- if we are searching for white spaces
		//	\\S	- if we are not searching for white spaces.
		//	[A-Za-z]{2,20}	-	if we want to check for words which are 2 to 20 characters long.
		//	\\w{2,20}
		
		//regexChecker("\\s[A-Za-z]{2,20}\\s",longString);		
		// the above method find all the strings which contains character from [A-Z] or [a-z] and which are 2 to 20 characters long.
		
		//regexChecker("\\s\\d{5}\\s",longString);
		//the above methods get all the words which are 5 characters long and contains digits.
		

		// 2 characters that start from a C or A
		//A[A-Z]|C[A-Z]
		//regexChecker("\\s\\A[A-Z]|C[A-Z]\\s",longString);
		
		//things which needs a blackslash in regex
		// . ^ + ? { } [ ] \ | ( )

		//+ represents the same characters which proceeds the some character.			
		//regexChecker("(\\{+)",strangeString);
	
		// To check an email
		regexChecker("[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}",longString);		
	}

	public static void regexChecker(String theRegex, String str2Check)
	{
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str2Check);

		while(regexMatcher.find())
		{
			if(regexMatcher.group().length()!=0)
			{
				System.out.println(regexMatcher.group().trim());
			}
			System.out.println("Start Index: "+regexMatcher.start());
			System.out.println("End Index: "+regexMatcher.end());
		}
	}
}
