package cs350s21project.cli;

import java.util.*;
import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.actor.*;
import cs350s21project.controller.command.misc.*;
import cs350s21project.controller.command.sensor.*;
import cs350s21project.controller.command.munition.*;
import cs350s21project.controller.command.view.*;
import cs350s21project.datatype.*;

public class CommandInterpreter extends java.lang.Object{
	
	
	public void evaluate(String commandText) throws Exception { // Evaluate method
		CommandManagers cm = new CommandManagers(); // CommandManager object creation
		
		String cmd = commandText.toLowerCase();
		String[] segments = cmd.split(" ");
		switch(segments[0]) { // Switch statement and cases for first segment after splitting
			case "define":
				switch (segments[1]) {
					case "sensor":
						switch (segments[2]) {
							case "radar":
								if (segments[4].equalsIgnoreCase("with")) {
									FieldOfView fov = null;
									Power power = null;
									Sensitivity sensitivity = null;
									AgentID id = new AgentID(segments[3]);
									if (cmd.contains("field of view ")) {
											 int fovnum = Integer.parseInt(cmd.split("field of view ")[1].split((" "))[0]); 
											 fov = new FieldOfView(new AngleNavigational(fovnum));
										}
									if (cmd.contains("power ")) {
										 int powernum = Integer.parseInt(cmd.split("power ")[1].split((" "))[0]); 
										 power = new Power(powernum);
									}
									if (cmd.contains("sensitivity ")) {
										int sensnum = Integer.parseInt(cmd.split("sensitivity ")[1].split((" "))[0]);
										sensitivity = new Sensitivity(sensnum);
										 
									}
									CommandSensorDefineRadar radarSensor = new CommandSensorDefineRadar(cm, cmd, id, fov, power, sensitivity);
									cm.schedule(radarSensor);
									System.out.println("radar sensor made");
								}
								else {
									throw new RuntimeException("Command Not Found");
								}
								break;
							
							case "thermal":
								if (segments[4].equalsIgnoreCase("with")) {
									FieldOfView fov = null;
									Sensitivity sensitivity = null;
									AgentID id = new AgentID(segments[3]);
									if (cmd.contains("field of view ")) {
											 int fovnum = Integer.parseInt(cmd.split("field of view ")[1].split((" "))[0]); 
											 fov = new FieldOfView(new AngleNavigational(fovnum));
										}
									if (cmd.contains("sensitivity ")) {
										int sensnum = Integer.parseInt(cmd.split("sensitivity ")[1].split((" "))[0]);
										sensitivity = new Sensitivity(sensnum);
									}
									CommandSensorDefineThermal thermalSensor = new CommandSensorDefineThermal(cm, cmd, id, fov, sensitivity);
									cm.schedule(thermalSensor);
								}else {
									throw new RuntimeException("Command Not Found");
								}
								
								break;
							
							case "sonar":
								switch (segments[3]) {
									case "active":
										Power power = null;
										Sensitivity sensitivity = null;
										AgentID id = new AgentID(segments[4]);
										if (cmd.contains("power ")) {
											 int powernum = Integer.parseInt(cmd.split("power ")[1].split((" "))[0]); 
											 power = new Power(powernum);
										}
										if (cmd.contains("sensitivity ")) {
											int sensnum = Integer.parseInt(cmd.split("sensitivity ")[1].split((" "))[0]);
											sensitivity = new Sensitivity(sensnum);
											 
										}
										CommandSensorDefineSonarActive activeSonarSensor = new CommandSensorDefineSonarActive(cm, cmd, id, power, sensitivity);
										cm.schedule(activeSonarSensor);
										break;
									case "passive":
										Sensitivity sensitivity1 = null;
										AgentID id1 = new AgentID(segments[4]);
										if (cmd.contains("sensitivity ")) {
											int sensnum = Integer.parseInt(cmd.split("sensitivity ")[1].split((" "))[0]);
											sensitivity1 = new Sensitivity(sensnum);
											 
										}
										CommandSensorDefineSonarPassive PassiveSonarSensor = new CommandSensorDefineSonarPassive(cm, cmd, id1, sensitivity1);
										cm.schedule(PassiveSonarSensor);
										break;
									default:
										throw new RuntimeException("Command Not Found");
								}
								break;
							
							case "acoustic":
								if (segments[4].equalsIgnoreCase("with")) {
									Sensitivity sensitivity1 = null;
									AgentID id = new AgentID(segments[3]);
									if (cmd.contains("sensitivity ")) {
										int sensnum = Integer.parseInt(cmd.split("sensitivity ")[1].split((" "))[0]);
										sensitivity1 = new Sensitivity(sensnum);
									}
									CommandSensorDefineAcoustic AcousticSensor = new CommandSensorDefineAcoustic(cm, cmd, id, sensitivity1);
									cm.schedule(AcousticSensor);
								}
								break;
							
							case "depth":
								if (segments[4].equalsIgnoreCase("with")) {
									Altitude depth = null;
									AgentID id = new AgentID(segments[3]);
									if (cmd.contains("trigger depth ")) {
										 int altitudenum = Integer.parseInt(cmd.split("trigger depth ")[1].split((" "))[0]); 
										 depth = new Altitude(altitudenum);
									}
									CommandSensorDefineDepth DepthSensor = new CommandSensorDefineDepth(cm, cmd, id, depth);
									cm.schedule(DepthSensor);
								}
								break;
							
							case "distance":
								if (segments[4].equalsIgnoreCase("with")) {
									DistanceNauticalMiles distance = null;
									AgentID id = new AgentID(segments[3]);
									if (cmd.contains("trigger distance ")) {
										 int distancenum = Integer.parseInt(cmd.split("trigger distance ")[1].split((" "))[0]); 
										 distance = new DistanceNauticalMiles(distancenum);
									}
									CommandSensorDefineDistance DistanceSensor = new CommandSensorDefineDistance(cm, cmd, id, distance);
									cm.schedule(DistanceSensor);
								}
								else {
									throw new RuntimeException("Command Not Found");
								}
								break;
							
							case "time":
								if (segments[4].equalsIgnoreCase("with")) {
									Time time = null;
									AgentID id = new AgentID(segments[3]);
									if (cmd.contains("trigger time ")) {
										 int timenum = Integer.parseInt(cmd.split("trigger time ")[1].split((" "))[0]); 
										 time = new Time(timenum);
									}
									CommandSensorDefineTime TimeSensor = new CommandSensorDefineTime(cm, cmd, id, time);
									cm.schedule(TimeSensor);
								}
								break;
							
							default:
								throw new RuntimeException("Command Not Found");
					
						}
            
						break;
						
					case "munition":
						switch(segments[2]) {
							case "bomb":
								AgentID id = new AgentID(segments[3]);
								CommandMunitionDefineBomb bomb = new CommandMunitionDefineBomb(cm, cmd, id);
								cm.schedule(bomb);
								break;
							case "shell":
								AgentID id1 = new AgentID(segments[3]);
								CommandMunitionDefineShell shell = new CommandMunitionDefineShell(cm, cmd, id1);
								cm.schedule(shell);
								break;
							case "depth_charge":
								if(segments[4].equalsIgnoreCase("with") && segments[5].equalsIgnoreCase("fuze")) {
								
									AgentID id2 = new AgentID(segments[3]);
									AgentID id3 = new AgentID(segments[6]);
	
									CommandMunitionDefineDepthCharge dCharge = new CommandMunitionDefineDepthCharge(cm, cmd,id2, id3);
									cm.schedule(dCharge);
								}
								break;
						case "torpedo":
							if(segments[4].equalsIgnoreCase("with") && segments[5].equalsIgnoreCase("sensor")) {
								AgentID id2 = new AgentID(segments[3]);
								AgentID id3 = new AgentID(segments[6]);
								AgentID id4 = new AgentID(segments[8]);
								Time time = null;
								if(cmd.contains("arming time ")) {
									int timenum = Integer.parseInt(cmd.split("arming time ")[1].split((" "))[0]);
									time = new Time(timenum);
								}
								CommandMunitionDefineTorpedo torpedo = new CommandMunitionDefineTorpedo(cm, cmd, id2, id3, id4, time);
								cm.schedule(torpedo);
							}
							break;
						case "missile":
							if(segments[4].equalsIgnoreCase("with") && segments[5].equalsIgnoreCase("sensor")) {
								AgentID id2 = new AgentID(segments[3]);
								AgentID id3 = new AgentID(segments[6]);
								AgentID id4 = new AgentID(segments[8]);
								DistanceNauticalMiles distance = null;
								if (cmd.contains("arming distance ")) {
									 int distancenum = Integer.parseInt(cmd.split("arming distance ")[1].split(" ")[0]); 
									 distance = new DistanceNauticalMiles(distancenum);
								}
								CommandMunitionDefineMissile DistanceMissile = new CommandMunitionDefineMissile(cm, cmd, id2, id3, id4, distance);
								cm.schedule(DistanceMissile);
							}
							break;
							
						}
						break;
						
					case "ship":
						AgentID sid = new AgentID(segments[2]);
						List<AgentID> munition = new ArrayList<AgentID>();
						if (segments[4].equalsIgnoreCase("munition") || segments[4].equalsIgnoreCase("munitions")) {
							for (int i = 5; i < segments.length; i++) {
								String ids = segments[i].replace("(", "");
								ids = ids.replace(")", "");
								munition.add(new AgentID(ids));
							}
						}
						CommandActorDefineShip Ship = new CommandActorDefineShip(cm, cmd, sid, munition);
						cm.schedule(Ship);
						break;
						
					default:
						throw new RuntimeException("Command Not Found");
				
					
				}
				break;
				
			case "create":				
				switch (segments[1]) {
					case "actor":
						if (segments.length == 12 && (segments[0] + segments[1] + segments[3] + segments[5] + segments[7]
								+ segments[8] + segments[10]).equalsIgnoreCase("createactorfromatwithcoursespeed")) {
							AgentID actorID = new AgentID(segments[2]);
							AgentID fromID = new AgentID(segments[4]);
							
							String[] splitCoords = segments[6].split("/");
							String[] split1 = splitCoords[0].split("*");
							String[] split2 = split1[1].split("'");
							
							int lat1 = Integer.parseInt(split1[0]);
							int lat2 = Integer.parseInt(split2[0]);
							double lat3 = Integer.parseInt(split2[1].replace("\"", ""));
							Latitude lat = new Latitude(lat1, lat2, lat3);
							
							split1 = splitCoords[2].split("*");
							split2 = split1[1].split("'");
							
							int lon1 = Integer.parseInt(split1[0]);
							int lon2 = Integer.parseInt(split2[0]);
							double lon3 = Integer.parseInt(split2[1].replace("\"", ""));
							Longitude lon = new Longitude(lon1, lon2, lon3);
							
							Altitude alt = new Altitude( Double.parseDouble(splitCoords[2]));
							CoordinateWorld3D coords = new CoordinateWorld3D(lat, lon, alt);
							
							Course course = new Course(Double.parseDouble(segments[9]));
							Groundspeed speed = new Groundspeed(Double.parseDouble(segments[11]));
							
							CommandActorCreateActor Actor = new CommandActorCreateActor(cm, cmd, actorID, fromID, coords, course, speed);
							cm.schedule(Actor);
						}else {
							throw new RuntimeException("Command Not Found");
						}
						
						
						break;
						
					case "window":
						if(segments.length == 13 && (segments[3] + segments[4] + segments[5]).equalsIgnoreCase("topviewwith")) {
						AgentID idWindow = new AgentID(segments[2]);
						int wSize = Integer.parseInt(segments[6]);
						
						String tempLatitude1 =  segments[7].replace("(", ""); // Removes initial parenthesis
						String latitude1 = tempLatitude1.replaceAll("\\p{Punct}", " "); // Replaces all punctuation characters with white space
						String[] latitude1Segments = latitude1.split(" ");
						Latitude latitudeOrigin = new Latitude(Integer.parseInt(latitude1Segments[0]), Integer.parseInt(latitude1Segments[1])
								, Double.parseDouble(latitude1Segments[2]));
						
						String latitude2 = segments[8].replaceAll("\\p{Punct}", " ");
						String[] latitude2Segments = latitude2.split(" ");
						Latitude latitudeExtent = new Latitude(Integer.parseInt(latitude2Segments[0]), Integer.parseInt(latitude2Segments[1])
								, Double.parseDouble(latitude2Segments[2]));
						
						String tempLatitude3 =  segments[9].replace(")", "");
						String latitude3 = tempLatitude3.replaceAll("\\p{Punct}", " ");
						String[] latitude3Segments = latitude3.split(" ");
						Latitude latitudeInterval = new Latitude(Integer.parseInt(latitude3Segments[0]), Integer.parseInt(latitude3Segments[1])
								, Double.parseDouble(latitude3Segments[2]));
						
				        String tempLongitude1 =  segments[10].replace("(", "");
				        String longitude1 = tempLongitude1.replaceAll("\\p{Punct}", " ");
				        String[] longitude1Segments = longitude1.split(" ");
				        Longitude longitudeOrigin = new Longitude(Integer.parseInt(longitude1Segments[0]), Integer.parseInt(longitude1Segments[1])
				                , Double.parseDouble(longitude1Segments[2]));
				        
				        String longitude2 = segments[11].replaceAll("\\p{Punct}", " ");
				        String[] longitude2Segments = longitude2.split(" ");
				        Longitude longitudeExtent = new Longitude(Integer.parseInt(longitude2Segments[0]), Integer.parseInt(longitude2Segments[1])
				                , Double.parseDouble(longitude2Segments[2]));
				        
				        String tempLongitude3 =  segments[12].replace(")", "");
				        String longitude3 = tempLongitude3.replaceAll("\\p{Punct}", " ");
				        String[] longitude3Segments = longitude3.split(" ");
				        Longitude longitudeInterval = new Longitude(Integer.parseInt(longitude3Segments[0]), Integer.parseInt(longitude3Segments[1])
				                , Double.parseDouble(longitude3Segments[2]));
				        
				        CommandViewCreateWindowTop cCreateWindowTop = new CommandViewCreateWindowTop(cm, cmd, idWindow, wSize, latitudeOrigin
				        		, latitudeExtent, latitudeInterval, longitudeOrigin, longitudeExtent, longitudeInterval);
				        
				        cm.schedule(cCreateWindowTop);
						}
						else {
							throw new RuntimeException("Command Not Found");
						}
				        break;
			        
			        default:
			        	throw new RuntimeException("Command Not Found");
				}
				break;
				
			case "delete":
				switch(segments[1]) {
					case "window":
						AgentID wID = new AgentID(segments[2]);
						CommandViewDeleteWindow cDeleteWindow = new CommandViewDeleteWindow(cm, cmd, wID);
						cm.schedule(cDeleteWindow);
						break;
						
					default:
						throw new RuntimeException("Command Not Found");						
				}
				
				break;

			case "set":
				switch(segments[2]) {
					case "course":
						AgentID cID = new AgentID(segments[1]);
						AngleNavigational angleNav = new AngleNavigational(Double.parseDouble(segments[3]));
						Course cCourse = new Course(angleNav);
						CommandActorSetCourse cSetCourse = new CommandActorSetCourse(cm, cmd, cID, cCourse);						
						cm.schedule(cSetCourse);
						break;

					case "speed":
						AgentID sID = new AgentID(segments[1]);
						Groundspeed sSpeed = new Groundspeed(Double.parseDouble(segments[3]));
						CommandActorSetSpeed sSetSpeed = new CommandActorSetSpeed(cm, cmd, sID, sSpeed);
						cm.schedule(sSetSpeed);
						break;

					case "altitude": case "depth":
						AgentID adID = new AgentID(segments[1]);
						Altitude sAltitude = new Altitude(Double.parseDouble(segments[3]));
						CommandActorSetAltitudeDepth SetAlt = new CommandActorSetAltitudeDepth(cm, cmd, adID, sAltitude);
						cm.schedule(SetAlt);	
						break;
						
					case "load": 
						if (segments[3].equalsIgnoreCase("munition")) {
							AgentID id1 = new AgentID(segments[1]);
							AgentID id2 = new AgentID(segments[4]);
							CommandActorLoadMunition setLoad = new CommandActorLoadMunition(cm, cmd, id1,id2);
							cm.schedule(setLoad);
						}else {
							throw new RuntimeException("Command Not Found");
						}
						break;
            
					case "deploy":
						if (segments[3].equalsIgnoreCase("munition")) {
							AgentID id1 = new AgentID(segments[1]);
							AgentID id2 = new AgentID(segments[4]);
							AttitudePitch elevation = null;
							AttitudeYaw azimuth = null;
							if (cmd.contains("at azimuth ")) {
								int Yaw = Integer.parseInt(cmd.split("at azimuth ")[1].split((" "))[0]);
								azimuth = new AttitudeYaw(Yaw);
							}
							
							if(cmd.contains("elevation "))
							{
								int attitude = Integer.parseInt(cmd.split("elevation ")[1].split((" "))[0]);
								elevation = new AttitudePitch(attitude);
							}
							CommandActorDeployMunitionShell setDeployShell = new CommandActorDeployMunitionShell(cm, cmd, id1, id2, azimuth, elevation);
							cm.schedule(setDeployShell);
						}else {
							throw new RuntimeException("Command Not Found");
						}
						break;
						
					default:
						throw new RuntimeException("Command Not Found");
				}

			case "@load":
				if(segments.length == 2) {
					CommandMiscLoad cmdLoad = new CommandMiscLoad(cm, cmd, segments[1]);
					cm.schedule(cmdLoad);					
				} else {
					throw new RuntimeException("Command Not Found");
				}
				
				break;
				
			case "@pause":
				CommandMiscPause cmdPause = new CommandMiscPause(cm, cmd);
				cm.schedule(cmdPause);
				break;
				
			case "@resume":
				CommandMiscResume cmdResume = new CommandMiscResume(cm, cmd);
				cm.schedule(cmdResume);
				break;
				
			case "@set":
				switch(segments[1]) {
					case "update":
						Time timeUpdate = new Time(Double.parseDouble(segments[2]));
						CommandMiscSetUpdate cmdUpdate = new CommandMiscSetUpdate(cm, cmd, timeUpdate);
						cm.schedule(cmdUpdate);
						break;
						
					default:
						throw new RuntimeException("Command Not Found");	
				}
				
				break;
				
			case "@wait":
				if(segments.length == 2) {
					Time timeWait = new Time(Double.parseDouble(segments[1]));
					CommandMiscWait cmdWait = new CommandMiscWait(cm, cmd, timeWait);
					cm.schedule(cmdWait);
				} else {
					throw new RuntimeException("Command Not Found");
				}
				
				break;
				
			case "@force":
				if(segments.length == 10 && (segments [2] + segments[3] + segments[5] + segments[6] + segments[8]).equalsIgnoreCase("statetowithcoursespeed")) {
					AgentID forceAgentID = new AgentID(segments[1]); // Creates AgentID object
					
					AngleNavigational angleNav = new AngleNavigational(Double.parseDouble(segments[7])); // Creates AngleNavigational object
					Course forceCourse = new Course(angleNav); // Creates Course object using AngleNavigational object
					
					Groundspeed forceGroundSpeed = new Groundspeed(Double.parseDouble(segments[9])); // Creates GroundSpeed Object
					
					String coordinateString = segments[4].replaceAll("\\p{Punct}", " "); // Replaces all punctuation characters with white space
					String[] coordinateSegments = coordinateString.split(" "); // Splits the String into String Array
					Latitude coordinateLatitude = new Latitude(Integer.parseInt(coordinateSegments[0])
							, Integer.parseInt(coordinateSegments[1]), Double.parseDouble(coordinateSegments[2])); // Creates Latitude Object
					Longitude coordinateLongitude = new Longitude(Integer.parseInt(coordinateSegments[3])
							, Integer.parseInt(coordinateSegments[4]), Double.parseDouble(coordinateSegments[5])); // Creates Longitude Object
					Altitude coordinateAltitude = new Altitude(Double.parseDouble(coordinateSegments[6])); // Creates Altitude Object
					CoordinateWorld3D forceCoordinate = new CoordinateWorld3D(coordinateLatitude, coordinateLongitude, coordinateAltitude);
					
					CommandActorSetState cmdForce = new CommandActorSetState(cm, cmd, forceAgentID, forceCoordinate
							, forceCourse, forceGroundSpeed); // Creates CommandActorSetState Object
					
					cm.schedule(cmdForce);
												
				} else {
					throw new RuntimeException("Command Not Found");
				}
				
				break;
				
			case "@exit":
				CommandMiscExit cmdExit = new CommandMiscExit(cm, cmd);
				cm.schedule(cmdExit);
				break;
		}
	}
}
