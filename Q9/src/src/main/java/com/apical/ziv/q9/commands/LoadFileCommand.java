/**
 * ShapeCommand.java
 */
package com.apical.ziv.q9.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.CommandHandler;
import com.apical.ziv.q9.consts.CommandTypeConsts;
import com.apical.ziv.q9.consts.ErrorConsts;
import com.apical.ziv.q9.consts.MainConsts;
import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.exceptions.ShapeException;
import com.apical.ziv.q9.interfaces.Command;
import com.apical.ziv.q9.interfaces.Shape;
import com.apical.ziv.q9.shapes.ClosedShape;
import com.apical.ziv.q9.shapes.Point;
import com.apical.ziv.q9.shapes.creators.ShapeFactory;
import com.apical.ziv.q9.shapes.memory.ShapeMemory;
import com.apical.ziv.q9.spring.SpringContext;

/**
 * @author ziv
 *
 */
public class LoadFileCommand implements Command {

	private static CommandHandler handler=SpringContext.getBean(CommandHandler.class);
	private static ShapeFactory shapeFactory = SpringContext.getBean(ShapeFactory.class);
	private static ShapeMemory shapeMemory = SpringContext.getBean(ShapeMemory.class);

	private String input;

	public LoadFileCommand(String input) {
		this.input = input;
	}
	@Override
	public void execute() throws ShapeException {
		String inputFile = 	input.substring(CommandTypeConsts.LOADFILE.length()).trim();
		if (StringUtils.isNotEmpty(inputFile)) {
			InputStream in = null;
			try {
				System.err.println(String.format("read from file: '%s'", new File(inputFile).getAbsolutePath()));
				handler.handle(in = new FileInputStream(inputFile));
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
	

}
