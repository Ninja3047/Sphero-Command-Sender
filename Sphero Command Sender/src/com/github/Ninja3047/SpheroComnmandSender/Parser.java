package com.github.Ninja3047.SpheroComnmandSender;

import se.nicklasgavelin.bluetooth.Bluetooth;
import se.nicklasgavelin.bluetooth.BluetoothDevice;
import se.nicklasgavelin.sphero.command.*;
import se.nicklasgavelin.sphero.Robot;
import se.nicklasgavelin.sphero.exception.InvalidRobotAddressException;
import se.nicklasgavelin.sphero.exception.RobotBluetoothException;

public class Parser
{
	Robot robot;

	public Parser(Robot r)
	{
		this.robot = r;
	}
	
	public void parse(String command)
	{
		String[] commands = command.split("\\s+");
		
		/*for(int i = 0; i < commands.length; i++)
		{
			System.out.println(commands[i]);
		}*/
		
		switch(commands[0].toLowerCase())
		{
			case "color":
				try
				{
					robot.sendCommand(new RGBLEDCommand(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), Integer.parseInt(commands[3])));
				} catch(Exception e)
				{
					System.err.println("Invalid Arguments");
					System.out.println("Syntax: color [red] [green] [blue]");
					System.out.println("Where the colors are numbers from 0-256");
					System.out.println("Example: color 256 0 0");
				}
				break;
			case "colour":
				try
				{
					robot.sendCommand(new RGBLEDCommand(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), Integer.parseInt(commands[3])));
				} catch(Exception e)
				{
					System.err.println("Invalid Arguments");
					System.out.println("Syntax: colour [red] [green] [blue]");
					System.out.println("Where the colours are numbers from 0-256");
					System.out.println("Example: colour 256 0 0");
				}
				break;
			case "spin":
				try
				{
					if(commands[1].toLowerCase().equals("left"))
					{
						robot.sendCommand( new SpinLeftCommand(Integer.parseInt(commands[2])));
					} else if(commands[1].toLowerCase().equals("right"))
					{
						robot.sendCommand( new SpinRightCommand(Integer.parseInt(commands[2])));
					} else
					{
						System.err.println("Invalid Arguments");
						System.out.println("Syntax: spin [direction] [speed]");
						System.out.println("Example: spin left 5");
					}
				} catch(Exception e)
				{
					System.err.println("Invalid Arguments");
					System.out.println("Syntax: spin [direction] [speed]");
					System.out.println("Example: spin left 5");
				}
				break;
			
		}
	}
}
