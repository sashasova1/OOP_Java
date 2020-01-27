package com.company;

import java.io.*;
import java.util.*;

class InsertionSort {
    /*Function to sort array using insertion sort*/
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

      /* Move elements of arr[0..i-1], that are
      greater than key, to one position ahead
      of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
    public class Main {

        static void printArray(int arr[])
        {
            int n = arr.length;
            for (int i = 0; i < n; ++i)
                System.out.print(arr[i] + " ");

            System.out.println();
        }
        private static Map<String, String> letters = new HashMap<String, String>();

        static {
            letters.put("А", "A");
            letters.put("Б", "B");
            letters.put("В", "V");
            letters.put("Г", "G");
            letters.put("Д", "D");
            letters.put("Е", "E");
            letters.put("Ё", "E");
            letters.put("Ж", "Zh");
            letters.put("З", "Z");
            letters.put("И", "I");
            letters.put("Й", "I");
            letters.put("К", "K");
            letters.put("Л", "L");
            letters.put("М", "M");
            letters.put("Н", "N");
            letters.put("О", "O");
            letters.put("П", "P");
            letters.put("Р", "R");
            letters.put("С", "S");
            letters.put("Т", "T");
            letters.put("У", "U");
            letters.put("Ф", "F");
            letters.put("Х", "Kh");
            letters.put("Ц", "C");
            letters.put("Ч", "Ch");
            letters.put("Ш", "Sh");
            letters.put("Щ", "Sch");
            letters.put("Ь", "'");
            letters.put("Ы", "Y");
            letters.put("Ъ", "'");
            letters.put("Э", "E");
            letters.put("Ю", "Yu");
            letters.put("Я", "Ya");
            letters.put("а", "a");
            letters.put("б", "b");
            letters.put("в", "v");
            letters.put("г", "g");
            letters.put("д", "d");
            letters.put("е", "e");
            letters.put("ё", "e");
            letters.put("ж", "zh");
            letters.put("з", "z");
            letters.put("и", "i");
            letters.put("й", "i");
            letters.put("к", "k");
            letters.put("л", "l");
            letters.put("м", "m");
            letters.put("н", "n");
            letters.put("о", "o");
            letters.put("п", "p");
            letters.put("р", "r");
            letters.put("с", "s");
            letters.put("т", "t");
            letters.put("у", "u");
            letters.put("ф", "f");
            letters.put("х", "h");
            letters.put("ц", "c");
            letters.put("ч", "ch");
            letters.put("ш", "sh");
            letters.put("щ", "sch");
            letters.put("ь", "'");
            letters.put("ы", "y");
            letters.put("ъ", "'");
            letters.put("э", "e");
            letters.put("ю", "yu");
            letters.put("я", "ya");
        }
        public static String toTranslit(String text) {
            StringBuilder sb = new StringBuilder(text.length());
            for (int i = 0; i<text.length(); i++) {
                String l = text.substring(i, i+1);
                if (letters.containsKey(l)) {
                    sb.append(letters.get(l));
                }
                else {
                    sb.append(l);
                }
            }
            return sb.toString();
        }
        private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
            public int compare(String str1, String str2) {
                int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
                if (res == 0) {
                    res = str1.compareTo(str2);
                }
                return res;
            }
        };

        public static void main(String args[])
        {
            int[] arr = { 12, 11, 13, 5, 6 };
            InsertionSort ob = new InsertionSort();
            ob.sort(arr);
            printArray(arr);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите слово: ");

            try {
                String s = br.readLine();
                Map<Character, Integer> map = new HashMap<Character, Integer>();
                for (char c : s.toCharArray()) {
                    if (!Character.isWhitespace(c)) {
                        if (map.containsKey(c)) {
                            map.put(c, map.get(c) + 1);
                        }
                        else {
                            map.put(c, 1);
                        }
                    }
                }
                map.keySet().forEach((c) -> {
                    System.out.println(c + ": " + map.get(c));
                });

            } catch (IOException e) {
                System.err.println("Error!");
                System.exit(1);
            }

            String test = "Яблоко, ЯБЛОКО, ХОРОШО, ХоРоШо";
            System.out.println("toTranslit(test) = " + toTranslit(test));

            List<String> list = new ArrayList();
            list.add("abc");
            list.add("Bab");
            list.add("BAA");
            list.add("bca");
            list.add("ccc");
            Collections.sort(list, ALPHABETICAL_ORDER);
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
