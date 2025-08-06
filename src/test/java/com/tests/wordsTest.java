package com.tests;

import org.modules.AnagramsCheck;
import org.modules.FindWordinDict;
import org.modules.PalindromeCheck;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.utils.ConfigFileReader;

public class wordsTest {

    private String[] words;
    @BeforeClass
    public void setUp(){
        String wordsarr=ConfigFileReader.getProperty("words");
        words=wordsarr.split(",");

    }


    @Test
    public void verifyWordFromDict(){
        for(int i=0;i<words.length;i++){
            Assert.assertTrue(FindWordinDict.isWordInDictionary(words[i]));
        }

    }

    @Test
    public void verifyWordisPalindrome(){
        for(int i=0;i<words.length;i++){
            Assert.assertTrue(PalindromeCheck.isPalindrome(words[i]));
        }
    }

    @Test
    public void verifyWordsareAnagram(){
        if(words.length==2){
            Assert.assertTrue(AnagramsCheck.areAnagrams(words[0],words[1]));
        }
        else{
            Assert.assertEquals(words.length, 2, "Input values do not match!");
        }
    }


}
