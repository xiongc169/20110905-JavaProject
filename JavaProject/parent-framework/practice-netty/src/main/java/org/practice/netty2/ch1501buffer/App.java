package org.practice.netty2.ch1501buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

import io.netty.buffer.ByteBuf;

public class App {

	public static void main(String[] args) {
		nioBuffer();
	}

	private static void nioBuffer() {

		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		CharBuffer charBuf = CharBuffer.allocate(1024);

		DoubleBuffer douBuf = DoubleBuffer.allocate(1024);
		FloatBuffer floBuf = FloatBuffer.allocate(1024);

		IntBuffer intBuf = IntBuffer.allocate(1024);
		LongBuffer longBuf = LongBuffer.allocate(1024);
		ShortBuffer shortBuf = ShortBuffer.allocate(1024);

		String book = "Netty 权威指南";
		byteBuffer.put(book.getBytes());
		byteBuffer.flip();
		byte[] copy = new byte[byteBuffer.remaining()];
		byteBuffer.get(copy);
		String decode = new String(copy);
		System.out.println(decode);
	}

	private static void nettyBuffer() {

		// ByteBuf AbstractByteBuf AbstractReferenceCountedByteBuf
		// UnpooledHeapByteBuf
	}

}
