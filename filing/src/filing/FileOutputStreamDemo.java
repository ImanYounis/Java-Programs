package filing;
import java.io.*;
//public class FileOutputStreamDemo {
//	public static void main(String args[]) {
//		int size;
//		try (FileInputStream f = new FileInputStream("input.txt")) {
//
//			System.out.println("Total Available Bytes: " + (size = f.available()));
//
//			int n = size / 40;//int i,a=0;
//			System.out.println("First " + n + " bytes of the file one read() at a time");
//			//while ((i=f.read())!=-1&&i<n) 
//			for(int i=0;i<n;i++){
//				System.out.print((char)f.read());
//				//a++;
//			}
//
//			System.out.println("\nStill Available: " + f.available());
//
//			System.out.println("Reading the next " + n + " with one read(b[])");
//			byte b[] = new byte[n];
//			if (f.read(b) != n) {
//				System.err.println("couldn't read " + n + " bytes.");
//			}
//
//			System.out.println(new String(b, 0, n));
//			System.out.println("\nStill Available: " + (size = f.available()));
//			System.out.println("Skipping half of remaining bytes with skip()");
//			f.skip(size / 2);
//			System.out.println("Still Available: " + f.available());
//
//			System.out.println("Reading " + n / 2 + " into the end of array");
//			if (f.read(b, n / 2, n / 2) != n / 2) {
//				System.err.println("couldn't read " + n / 2 + " bytes.");
//			}
//
//			System.out.println(new String(b, 0, b.length));
//			System.out.println("\nStill Available: " + f.available());
//		} catch (IOException e) {
//			System.out.println("I/O Error: " + e);
//		}
//	}
//}

//public class FileOutputStreamDemo {
//	public static void main(String args[]) { 
//	    String source = "Now is the time for all good men\n" 
//	      + " to come to the aid of their country\n" 
//	      + " and pay their due taxes."; 
//	    byte buf[] = source.getBytes(); 
//	    FileOutputStream f0 = null; 
//	    FileOutputStream f1 = null; 
//	    FileOutputStream f2 = null; 
//	 
//	    try { 
//	      f0 = new FileOutputStream("file.txt"); 
//	      f1 = new FileOutputStream("input.txt"); 
//	      f2 = new FileOutputStream("output.txt"); 
//	 
//	      // write to first file 
//	      for (int i=0; i < buf.length; i += 2) f0.write(buf[i]);      
//	 
//	      // write to second file 
//	      f1.write(buf); 
//	 
//	      // write to third file 
//	      f2.write(buf, buf.length-buf.length/4, buf.length/4); 
//	    } catch(IOException e) { 
//	      System.out.println("An I/O Error Occured"); 
//	    } finally { 
//	      try { 
//	        if(f0 != null) f0.close(); 
//	      } catch(IOException e) { 
//	        System.out.println("Error Closing file1.txt"); 
//	      } 
//	      try { 
//	        if(f1 != null) f1.close(); 
//	      } catch(IOException e) { 
//	        System.out.println("Error Closing file2.txt"); 
//	      } 
//	      try { 
//	        if(f2 != null) f2.close(); 
//	      } catch(IOException e) { 
//	        System.out.println("Error Closing file3.txt"); 
//	      } 
//	    } 
//	  }
//}
 
public class FileOutputStreamDemo{  
    public static void main(String[] args) throws Exception {  
        char ary[] = {'1','-','-','2','-','3','4','-','-','-','5','6'};  
        CharArrayReader reader = new CharArrayReader(ary);   
        PushbackReader push = new PushbackReader(reader);  
        int i;  
            while( (i = push.read())!= -1) {  
                if(i == '-') {  
                    int j;  
                    if( (j = push.read()) == '-'){  
                         System.out.print("#*");  
                    }else {  
                        push.unread(j); // push back single character  
                        System.out.print((char)i);  
                    }  
                }else {  
                        System.out.print((char)i);  
                }  
           }         
    }  
}