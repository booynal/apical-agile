/**
 * CommandHandler.java
 */
package com.apical.ziv.q9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.commands.creators.CommandFactory;
import com.apical.ziv.q9.consts.ErrorConsts;
import com.apical.ziv.q9.consts.MainConsts;
import com.apical.ziv.q9.exceptions.ShapeException;
import com.apical.ziv.q9.interfaces.Command;

/**
 * @author ziv
 *
 */
@Component
public class CommandHandler {

	@Autowired
	private CommandFactory commandFactory;

	public void handle() {
		handleFromFile();
		handleFromConsole();
	}

	private void handleFromFile() {
		String inputFile = System.getProperty(MainConsts.COMMAND_LINE_INPUT_FILE);
		if (StringUtils.isNotEmpty(inputFile)) {
			InputStream in = null;
			try {
				System.err.println(String.format("read from file: '%s'", new File(inputFile).getAbsolutePath()));
				handle(in = new FileInputStream(inputFile));
				System.err.println("parse file done");
			} catch (FileNotFoundException e) {
				System.err.println(String.format("%s: %s", ErrorConsts.ERROR_301, inputFile));
			} finally {
				if (null != in) {
					try {
						in.close();
					} catch (IOException e) {
					}
				}
			}
		}
	}

	private void handleFromConsole() {
		handle(System.in);
	}

	private void handle(InputStream in) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(in);
			loop(scanner);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != scanner) {
				scanner.close();
			}
		}
	}

	private void loop(Scanner scanner) {
		while (scanner.hasNextLine()) {
			try {
				handleOneLine(scanner.nextLine());
			} catch (ShapeException e) {
				System.err.println(e.getMessage());
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private void handleOneLine(String line) throws ShapeException {
		String nonNullString = StringUtils.trimToEmpty(line);
		if (StringUtils.isEmpty(nonNullString)) {
			return;
		}

		Command command = commandFactory.create(nonNullString);
		if (null != command) {
			command.execute();
		} else {
			throw new ShapeException(String.format("%s: %s", ErrorConsts.ERROR_004, line));
		}
	}

}
