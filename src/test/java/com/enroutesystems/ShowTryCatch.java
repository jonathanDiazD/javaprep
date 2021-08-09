package com.enroutesystems;

import java.io.IOException;
import java.net.BindException;
import java.util.Random;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShowTryCatch {

	public static void randomException() throws IOException {
		Random r = new Random();
		int low = 0;
		int high = 10;
		int result = r.nextInt(high - low) + low;
		if (5 <= result) {
			throw new BindException("Some regular exception");
		} else {
			throw new IOException("Some illegal argument exception");
		}

	}

	@Test
	public void showCatch() {

		try {

			ShowTryCatch.randomException();
		} catch (BindException e) {
			log.error("Got exception: {}", e.getMessage(), e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
