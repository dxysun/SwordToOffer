package myTest;

import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.Set;

public class MyNioTest {

    public static void channelDemo() {
        try {
            RandomAccessFile aFile = new RandomAccessFile("D:\\code\\test.txt", "rw");
            FileChannel inChannel = aFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(1024);

            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {
                System.out.println();
                System.out.println("Read:" + bytesRead);
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }

                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            aFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void trans() {
        try {
           /* RandomAccessFile fromFile = new RandomAccessFile("D:\\code\\fromFile.txt", "rw");
            FileChannel      fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("D:\\code\\toFile.txt", "rw");
            FileChannel      toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size();

            toChannel.transferFrom(fromChannel,position, count);*/

            RandomAccessFile fromFile = new RandomAccessFile("D:\\code\\fromFile.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("D:\\code\\toFile.txt", "rw");
            FileChannel toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size();

            fromChannel.transferTo(position, count, toChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void clean(final MappedByteBuffer buffer) throws Exception {
        if (buffer == null) {
            return;
        }
        buffer.force();
        AccessController.doPrivileged(new PrivilegedAction<Object>() {//Privileged特权
            @Override
            public Object run() {
                try {
                    // System.out.println(buffer.getClass().getName());
                    Method getCleanerMethod = buffer.getClass().getMethod("cleaner", new Class[0]);
                    getCleanerMethod.setAccessible(true);
                    sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod.invoke(buffer, new Object[0]);
                    cleaner.clean();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    public static void main(String[] args) {
        try {
//            int length = 0x8FFFFFF;//一个byte占1B，所以共向文件中存128M的数据

            long len = 0x1FFFFFFFFFL;
            int length = 0xFFFFFF;//一个byte占1B，所以共向文件中存16M的数据
            try (FileChannel channel = FileChannel.open(Paths.get("D:\\code\\test.txt"),
                    StandardOpenOption.READ, StandardOpenOption.WRITE)) {
                MappedByteBuffer mapBuffer0 = channel.map(FileChannel.MapMode.READ_WRITE, 0, 50);
//                MappedByteBuffer mapBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 100, 200);

//                Integer a = 289;
//                System.out.println("mapBuffer.position():"+mapBuffer.position());
//                mapBuffer0.position(49);
             /*   for(Integer i=0;i<32;i++) {
                    Integer a = i + 10;
                    mapBuffer.put(a.byteValue());
                }
                ByteBuffer localBuffer = ByteBuffer.allocate(16);*/
//                byte[] bytes = new byte[8];
////                mapBuffer.position(48);
//                for(int i = 0;i < 4;i ++){
//                    bytes[i] = Integer.valueOf(i + 50).byteValue();
//                }
//                localBuffer.put(bytes);
//                System.out.println("localBuffer:"+localBuffer.position());
//                System.out.println("localBuffer:"+localBuffer.capacity());
//                localBuffer.position(16);
//                mapBuffer.put(localBuffer);
//                mapBuffer.put(bytes);
                int a = 200;
                long c = 300;
                mapBuffer0.putInt(a);
                mapBuffer0.putLong(c);
                byte[] b = NumberUtil.intToByte4(200);
                byte[] e = NumberUtil.long2Bytes(c);
                long d = 300;
                mapBuffer0.put(b);
                mapBuffer0.put(e);
//                System.out.println("mapBuffer:"+mapBuffer.position());
//                System.out.println("mapBuffer0:"+mapBuffer.position());
//                mapBuffer.put(bytes,4,4);
               /* mapBuffer.get(bytes,0,8);
                for (byte b : bytes){
                    System.out.println(b);
                }*/
                System.out.println();
//                mapBuffer.position(50);
//                MappedByteBuffer mapBuffer1 = channel.map(FileChannel.MapMode.READ_WRITE, 60, 100);
//                for(Integer i=0;i<30;i++) {
//                    Integer a = i + 30;
//
//                    mapBuffer1.put(a.byteValue());
//                }
//                mapBuffer.flip();
//                System.out.println(mapBuffer1.get());
              /*  if(mapBuffer == mapBuffer1)
                    System.out.println("equal");
                else
                    System.out.println("not equal");

                clean(mapBuffer);
                clean(mapBuffer1);
                Files.delete(Paths.get("D:\\code\\test.txt"));
                System.out.println("删除成功!");
                for(int i = length/2;i<length/2+4;i++) {
                    //像数组一样访问
                    System.out.println(mapBuffer.get(i));
                }*/
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
