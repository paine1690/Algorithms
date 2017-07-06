package code.topcoder;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}


/**
 * 
 * 
Problem Statement
    
Elly really likes palindromic numbers (e.g. 171 and 4224). She also really likes prime numbers (e.g. 13 and 1,000,000,009). The numbers, which are both prime and palindromic (e.g. 11 and 946,474,649) she simply LOVES!  Elly told you that she has found N such numbers A1, A2, …, AN, with exactly D digits each. In order to keep them secret, she has encoded them in the following way. First, she thinks of a new number X with exactly D digits (which is not necessarily either prime or palindrome), which she calls a "key". After that, to each digit in each of the numbers Ai, she adds the corresponding digit in X and records the result modulo 10. This way she obtains a new list of N numbers with exactly D digits each, which, however, are possibly neither prime nor palindromic. Still, if you know the key X, you can easily transform them back into the original palindromic primes.  Note that unnecessary leading zeroes are not allowed anywhere. For D > 1 this means that none of the numbers mentioned in the previous paragraph will start with a zero.  For example, suppose the list Elly had contained the numbers (71317, 13331, 96769, 79397, 34543, 73237) and the chosen key X was 42666. Then, the resulting list would be (13973, 55997, 38325, 11953, 76109, 15893).  You have found a list of D-digit numbers under Elly's desk. These numbers are given to you in the String[] numbers. Now you wonder whether it may be the mentioned list of encoded palindromic primes. Can you find a key, which Elly could have used? If yes, return it as a string. If several possibilities exist, return the smallest one. If no possible key satisfies the requirements, return "No solution" instead.
Definition
    
Class:
EllysPrimePals
Method:
getKey
Parameters:
String[]
Returns:
String
Method signature:
String getKey(String[] numbers)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
256
Notes
-
Since we want all the numbers in this problem to have exactly D digits, none of them can have leading zeroes. This includes the prime palindromes, the key, and the encoded numbers.
-
A prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself.
-
A palindromic number is a number that remains the same when when you read it backwards reversed.
Constraints
-
numbers will contain between 1 and 100 elements, inclusive.
-
Each element in numbers will only contain digits ('0'-'9').
-
None of the elements of numbers will have leading zeroes.
-
All elements of numbers will have the same length D, which will be between 1 and 10 digits, inclusive.
Examples
0)

    
{"13973", "55997", "38325", "11953", "76109", "15893"}
Returns: "42666"
The example from the problem statement.
1)

    
{"173", "961", "193", "739", "123"}
Returns: "No solution"
Here the key 042 would work, however since we want only numbers with exactly D digits, we consider it invalid.
2)

    
{"667", "263", "203", "263", "495", "677", "667", "233", "859", "667",
 "677", "233", "203", "869", "405", "859", "839", "405", "667", "869",
 "405", "617", "839", "263", "899", "495", "263", "839", "839", "263",
 "495", "667", "263", "687", "637", "859", "899", "859", "203", "869",
 "899", "617"}
Returns: "586"

3)

    
{"70450585", "54404089", "34381879", "37184852", "33404088", "55595990", "34593999", "59239364",
 "35956530", "72248467", "54552599", "71087846", "18169653", "56904031", "38376773", "70335375",
 "73594998", "78953533", "57751512", "19367674", "14296969", "38069643", "51196956", "12800027",
 "10723215", "34160659", "52863627", "75511190", "37681802", "15455580", "10524295", "58853523",
 "50491985", "51930336", "13669608", "13217168", "15377770", "53490988", "37078742", "34480889",
 "74713119", "50818125", "17641402", "70435385", "33391978", "51698906", "55123250", "18738313",
 "56396971", "50754515", "93376733", "16190951", "38098943", "14174759", "53083848", "15816120",
 "75862620", "55575790", "16817121", "10161655", "14173759", "12143457", "31007046", "57346472",
 "76649401", "12713117", "77265662", "57158552", "72466687", "51759516", "31893926", "57523292",
 "34706019", "57173752", "13702018", "73396978", "11203066", "58426283", "70114155", "74032349",
 "53277768", "17303072", "76548491", "30978735", "54744419", "14440489", "76496981", "10869625",
 "70558595", "50147455", "53663608", "12483887", "51517196", "54804029", "59438384", "37311172",
 "77931332", "34250569", "17093942", "35252560"}
Returns: "No solution"

4)

    
{"704505859", "544040897", "343818795", "371848525", "334040885", "555959907", "345939995", "592393647",
 "359565305", "722484679", "545525997", "710878469", "181696533", "569040317", "383767735", "703353759",
 "735949989", "789535339", "577515127", "193676743", "142969693", "380696435", "511969567", "128000273",
 "107232153", "341606595", "528636277", "755111909", "376818025", "154555803", "105242953", "588535237",
 "504919857", "519303367", "136696083", "132171683", "153777703", "534909887", "370787425", "344808895",
 "747131199", "508181257", "176414023", "704353859", "333919785", "516989067", "551232507", "187383133",
 "563969717", "507545157", "143595793", "161909513", "380989435", "141747593", "530838487", "158161203",
 "758626209", "555757907", "168171213", "101616553", "141737593", "121434573", "310070465", "573464727",
 "766494019", "127131173", "772656629", "571585527", "724666879", "517595167", "318939265", "575232927",
 "347060195", "571737527", "137020183", "733969789", "112030663", "584262837", "701141559", "740323499",
 "532777687", "173030723", "765484919", "309787355", "547444197", "144404893", "764969819", "108696253",
 "705585959", "501474557", "536636087", "124838873", "515171967", "548040297", "594383847", "373111725",
 "779313329", "342505695", "170939423", "352525605"}
Returns: "431434586"

5)

    
{"3"}
Returns: "0"
The number 3 is already a prime palindrome, so the smallest valid key is 0. Note that this is allowed: The number 0 is a valid 1-digit number. This is because its only digit isn't an unnecessary leading zero.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.

* */