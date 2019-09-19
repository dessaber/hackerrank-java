package blockchain;

import java.util.Date;
import java.security.MessageDigest;

public class Blockchain {

    private static int blockCount = 0;
    private Block lastBlock;

    public Block generate() {
        long timestamp = new Date().getTime();
        String prevHash;
        if (blockCount == 0) {
            prevHash = "0";
        } else {
            prevHash = lastBlock.getHash();
        }
        String hash = StringUtil.applySha256(prevHash + timestamp % 193);
        lastBlock = new Block(++blockCount, timestamp, hash, prevHash);
        return lastBlock;
    }

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        int count = 10;
        while (count > 0) {
            System.out.println(blockchain.generate());
            count--;
        }
    }
}

class Block {
    private int id;
    private String hash;
    private String prevHash;
    private long timeStamp;

    public Block(int id, long timeStamp, String hash, String prevHash) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.hash = hash;
        this.prevHash = prevHash;
    }

    public String getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return "Block:" +
               "\nId: " + id +
               "\nTimestamp: " + timeStamp +
               "\nHash of the previous block:\n" + prevHash +
               "\nHash of the block:\n" + hash + "\n";
    }
}

class StringUtil {
    /* Applies Sha256 to a string and returns a hash. */
    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte elem: hash) {
                String hex = Integer.toHexString(0xff & elem);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
