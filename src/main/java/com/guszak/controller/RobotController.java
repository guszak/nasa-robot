package com.guszak.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guszak.exception.RobotException;
import com.guszak.model.Robot;

@RestController
@RequestMapping("/rest/mars")
public class RobotController {

	@RequestMapping(value = "/{movements}", method = RequestMethod.POST)
	public ResponseEntity<?> executeMovements(@PathVariable String movements) throws RobotException{
		Robot robot = new Robot();
		robot.executeMovements(movements);
		if (robot.getError()){
			throw new RobotException("400 Bad Request");
		}
		return new ResponseEntity<>(robot.getPosition(), HttpStatus.OK);
	}
}