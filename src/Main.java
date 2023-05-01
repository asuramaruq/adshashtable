import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        MyHashTable<MyTestingClass,String> hashTable = new MyHashTable<>();
        for (int i=0;i<10000;i++){
            hashTable.put(new MyTestingClass(generateString(10)),generateString(10));
        }
        System.out.println();
        System.out.println("buckets: "+Arrays.toString(hashTable.sizeOfBuckets()));
    }

    static String generateString(int l){
        String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        StringBuilder s= new StringBuilder(l);
        int i;
        for(i=0;i<l;i++){
            int ch=(int)(alphabet.length()*Math.random());
            s.append(alphabet.charAt(ch));
        }
        return s.toString();
    }
}