package nio.test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/1
 */
interface FileCopyRunner {

    void copyFile(File source, File target);
}

public class FileCopyTest {

    private static final int ROUNDS = 5;

    private static void benchmark(FileCopyRunner test, File source, File target) {
        long elapsed = 0;
        for (int i = 0; i < ROUNDS; i++) {
            long startTime = System.currentTimeMillis();
            test.copyFile(source, target);
            elapsed += System.currentTimeMillis() - startTime;
            target.delete();
        }
        System.out.println(test + ":" + elapsed / ROUNDS);
    }

    public static void main(String[] args) {
        File source = new File("D:\\software\\VMware.zip");
        File target = new File("D:\\software\\VMware2.zip");
        benchmark(noBufferStreamCopy(), source, target);
        benchmark(bufferedStreamCopy(), source, target);
        benchmark(nioBufferCopy(), source, target);
        benchmark(nioTransferCopy(), source, target);
    }

    private static FileCopyRunner noBufferStreamCopy() {
        return new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                InputStream inputStream = null;
                OutputStream outputStream = null;

                try {
                    inputStream = new FileInputStream(source);
                    outputStream = new FileOutputStream(target);
                    int result;
                    while ((result = inputStream.read()) != 1) {
                        outputStream.write(result);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(inputStream);
                    close(outputStream);
                }
            }

            @Override
            public String toString() {
                return "noBufferStreamCopy";
            }
        };
    }

    private static FileCopyRunner bufferedStreamCopy() {
        return new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                InputStream inputStream = null;
                OutputStream outputStream = null;

                try {
                    inputStream = new BufferedInputStream(new FileInputStream(source));
                    outputStream = new BufferedOutputStream(new FileOutputStream(target));
                    byte[] buffer = new byte[1024];
                    int result;
                    while ((result = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, result);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(inputStream);
                    close(outputStream);
                }
            }

            @Override
            public String toString() {
                return "bufferedStreamCopy";
            }
        };
    }

    private static FileCopyRunner nioBufferCopy() {
        return new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                FileChannel inputFileChannel = null;
                FileChannel outputFileChannel = null;

                try {
                    inputFileChannel = new FileInputStream(source).getChannel();
                    outputFileChannel = new FileOutputStream(target).getChannel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    while (inputFileChannel.read(byteBuffer) != -1) {
                        byteBuffer.flip();
                        while (byteBuffer.hasRemaining()) {
                            outputFileChannel.write(byteBuffer);
                        }
                        byteBuffer.clear();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(inputFileChannel);
                    close(outputFileChannel);
                }
            }

            @Override
            public String toString() {
                return "nioBufferStreamCopy";
            }
        };
    }

    private static FileCopyRunner nioTransferCopy() {
        return new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                FileChannel inputFileChannel = null;
                FileChannel outputFileChannel = null;

                try {
                    inputFileChannel = new FileInputStream(source).getChannel();
                    outputFileChannel = new FileOutputStream(target).getChannel();
                    long transferred = 0;
                    long size = inputFileChannel.size();
                    while (transferred != size) {
                        transferred += inputFileChannel.transferTo(0, size, outputFileChannel);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(inputFileChannel);
                    close(outputFileChannel);
                }
            }

            @Override
            public String toString() {
                return "nioTransferCopy";
            }
        };
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}