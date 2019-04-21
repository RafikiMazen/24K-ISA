import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import main.Simulation;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JLabel;

public class gui {

	public String  R1, R2,R3, opcode ;
	String instToBits;
	ArrayList <String> instructionList = new ArrayList<String>();
	Simulation simulation;
	private JFrame frame;
	private JTextField txtEnterInstructionsHere;
	ArrayList <String> string= new ArrayList<String>();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public gui() {
		simulation=new Simulation();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 797, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 239, 213));
		frame.getContentPane().add(panel);
		panel.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JTextPane textPane = new JTextPane();
		panel.add(textPane, "2, 2, 1, 3, fill, fill");
		
				JLabel lblNewLabel = new JLabel("Registers: $a0-$a5,$b0-$b5,$d0-$d5,$r0-$r5,$y0-$y5, $24k,$zero ");
				lblNewLabel.setBackground(new Color(255, 250, 240));
				panel.add(lblNewLabel, "2, 6");
		
				JLabel lblNewLabel_1 = new JLabel(
						"Instructions:  LOAD, SAVE, ADD, SUB, SET, SHIFTR, SHIFTL, MUL,DIV,AND,OR,NOT,XOR,THNS,THNSALL,JUMP,JUMPI,JAL,BEQ,BNEQ");
				panel.add(lblNewLabel_1, "2, 8");
		
				txtEnterInstructionsHere = new JTextField();
				txtEnterInstructionsHere.setForeground(new Color(176, 196, 222));
				txtEnterInstructionsHere.setText("Enter instructions Here");
				panel.add(txtEnterInstructionsHere, "2, 12, fill, default");
				txtEnterInstructionsHere.setColumns(10);
		
		JButton btnAddToList = new JButton("add to list");
		btnAddToList.setBackground(new Color(176, 196, 222));
		btnAddToList.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 15));
		btnAddToList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String instruction = txtEnterInstructionsHere.getText();
				String []instArray = instruction.split(" ");
			
		    	System.out.println(instruction);
		    	System.out.println(instArray[0]);

				if (instArray[0].equalsIgnoreCase("load")) {
					  opcode = "00000";
				} else {
					if (instArray[0].equalsIgnoreCase("save")) {
						  opcode = "00001";
					} else {
						if (instArray[0].equalsIgnoreCase("add")) {
							  opcode = "00010";
						} else {
							if (instArray[0].equalsIgnoreCase("sub")) {
								  opcode = "00011";
							} else {
								if (instArray[0].equalsIgnoreCase("set")) {
									  opcode = "00100";
								} else {
									if (instArray[0].equalsIgnoreCase("shftr")) {
										  opcode = "00101";
									} else {
										if (instArray[0].equalsIgnoreCase("shftl")) {
											  opcode = "00110";
										} else {
											if (instArray[0].equalsIgnoreCase("mul")) {
												  opcode = "00111";
											} else {
												if (instArray[0].equalsIgnoreCase("div")) {
													  opcode = "01000";
												} else {
													if (instArray[0].equalsIgnoreCase("and")) {
														  opcode = "01001";
													} else {
														if (instArray[0].equalsIgnoreCase("or")) {
															  opcode = "01010";
														} else {
															if (instArray[0].equalsIgnoreCase("not")) {
																  opcode = "01100";
															} else {
																if (instArray[0].equalsIgnoreCase("xor")) {
																	  opcode = "01101";
																} else {
																	if (instArray[0].equalsIgnoreCase("thns")) {
																		  opcode = "01110";
																	} else {
																		if (instArray[0].equalsIgnoreCase("thnsall")) {
																			  opcode = "01111";
																		} else {
																			if (instArray[0].equalsIgnoreCase("slt")) {
																				  opcode = "10000";
																			} else {
																				if (instArray[0].equalsIgnoreCase("jump")) {
																					  opcode = "10001";
																				} else {
																					if (instArray[0].equalsIgnoreCase("jal")) {
																						  opcode = "10010";
																					} else {
																						if (instArray[0]
																								.equalsIgnoreCase("jumpi")) {
																							  opcode = "10011";
																						} else {
																							if (instArray[0]
																									.equalsIgnoreCase("beq")) {
																								  opcode = "10100";
																							} else {
																								if (instArray[0]
																										.equalsIgnoreCase(
																												"bneq")) {
																									  opcode = "10101";
																								} else {
																									textPane.setText( textPane.getText()+
																											"instruction not available ");

																								}
																							}
																						}

																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}

					}

		            textPane.setText(textPane.getText()+ opcode); 
				}
				
				if (instArray.length>1) {
					
					if (isNumeric(instArray[1]))
					{	int number;
					 number = Integer.parseInt(instArray[1]);	
					 R1 = Integer.toBinaryString(number);
					 
					 while(R1.length()<27) {
						 R1 = "0"+R1;
					 }
					}
						
					//	toBinaryString();

					
					else {
				if (instArray[1].equalsIgnoreCase("$a0")) {
					  R1 = "00000";
				} else {
					if (instArray[1].equalsIgnoreCase("$a1")) {
						  R1 = "00001";
					} else {
						if (instArray[1].equalsIgnoreCase("$a2")) {
							  R1 = "00010";
						} else {
							if (instArray[1].equalsIgnoreCase("$a3")) {
								  R1 = "00011";
							} else {
								if (instArray[1].equalsIgnoreCase("$a4")) {
									  R1 = "00100";
								} else {
									if (instArray[1].equalsIgnoreCase("$a5")) {
										  R1 = "00101";
									} else {
										if (instArray[1].equalsIgnoreCase("$b0")) {
											  R1 = "00110";
										} else {
											if (instArray[1].equalsIgnoreCase("$b1")) {
												  R1 = "00111";
											} else {
												if (instArray[1].equalsIgnoreCase("$b2")) {
													  R1 = "01000";
												} else {
													if (instArray[1].equalsIgnoreCase("$b3")) {
														  R1 = "01001";
													} else {
														if (instArray[1].equalsIgnoreCase("$b4")) {
															  R1 = "01010";
														} else {
															if (instArray[1].equalsIgnoreCase("$b5")) {
																  R1 = "01011";
															} else {
																if (instArray[1].equalsIgnoreCase("$d0")) {
																	  R1 = "01100";
																} else {
																	if (instArray[1].equalsIgnoreCase("$d1")) {
																		  R1 = "01101";
																	} else {
																		if (instArray[1].equalsIgnoreCase("$d2")) {
																			  R1 = "01110";
																		} else {
																			if (instArray[1].equalsIgnoreCase("$d3")) {
																				  R1 = "01111";
																			} else {
																				if (instArray[1].equalsIgnoreCase("$d4")) {
																					  R1 = "10000";
																				} else {
																					if (instArray[1].equalsIgnoreCase("$d5")) {
																						  R1 = "10001";
																					} else {
																						if (instArray[1]
																								.equalsIgnoreCase("$r0")) {
																							  R1 = "10010";
																						} else {
																							if (instArray[1]
																									.equalsIgnoreCase("$r1")) {
																								  R1 = "10011";
																							} else {
																								if (instArray[1]
																										.equalsIgnoreCase(
																												"$r2")) {
																									  R1 = "10100";
																								} else {
																									if (instArray[1]
																											.equalsIgnoreCase(
																													"$r3")) {
																										  R1 = "10101";
																									} else {
																										if (instArray[1]
																												.equalsIgnoreCase(
																														"$r4")) {
																											  R1 = "10110";
																										} else {
																											if (instArray[1]
																													.equalsIgnoreCase(
																															"$r5")) {
																												  R1 = "10111";
																											} else {
																												if (instArray[1]
																														.equalsIgnoreCase(
																																"$y0")) {
																													  R1 = "11000";
																												} else {
																													if (instArray[1]
																															.equalsIgnoreCase(
																																	"$y1")) {
																														  R1 = "11001";
																													} else {
																														if (instArray[1]
																																.equalsIgnoreCase(
																																		"$y2")) {
																															  R1 = "11010";
																														} else {
																															if (instArray[1]
																																	.equalsIgnoreCase(
																																			"$y3")) {
																																  R1 = "11011";
																															} else {
																																if (instArray[1]
																																		.equalsIgnoreCase(
																																				"$y4")) {
																																	  R1 = "11100";
																																} else {
																																	if (instArray[1]
																																			.equalsIgnoreCase(
																																					"$y5")) {
																																		  R1 = "11101";
																																	} else {
																																		if (instArray[1]
																																				.equalsIgnoreCase(
																																						"$24k")) {
																																			  R1 = "11110";
																																		} else {
																																			if (instArray[1]
																																					.equalsIgnoreCase(
																																							"$zero")) {
																																				  R1 = "11111";
																																			} else {

																																				textPane.setText(textPane.getText()+
																																						"register not available");

																																			}
																																		}
																																	}

																																}
																															}
																														}

																													}
																												}
																											}

																										}

																									}
																								}
																							}

																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}

						}}
					}
				}

	        
				}
				
				if (instArray.length>2) {
					
					if (isNumeric(instArray[2]))
					{	int number;
					 number = Integer.parseInt(instArray[2]);	
					 R2 = Integer.toBinaryString(number);
					 
					 while(R2.length()<22) {
						 R2 = "0"+R2;
					 }
					}
					else {
					if (instArray[2].equalsIgnoreCase("$a0")) {
						  R2 = "00000";
					} else {
						if (instArray[2].equalsIgnoreCase("$a1")) {
							  R2 = "00001";
						} else {
							if (instArray[2].equalsIgnoreCase("$a2")) {
								  R2 = "00010";
							} else {
								if (instArray[2].equalsIgnoreCase("$a3")) {
									  R2 = "00011";
								} else {
									if (instArray[2].equalsIgnoreCase("$a4")) {
										  R2 = "00100";
									} else {
										if (instArray[2].equalsIgnoreCase("$a5")) {
											  R2 = "00101";
										} else {
											if (instArray[2].equalsIgnoreCase("$b0")) {
												  R2 = "00110";
											} else {
												if (instArray[2].equalsIgnoreCase("$b1")) {
													  R2 = "00111";
												} else {
													if (instArray[2].equalsIgnoreCase("$b2")) {
														  R2 = "01000";
													} else {
														if (instArray[2].equalsIgnoreCase("$b3")) {
															  R2 = "01001";
														} else {
															if (instArray[2].equalsIgnoreCase("$b4")) {
																  R2 = "01010";
															} else {
																if (instArray[2].equalsIgnoreCase("$b5")) {
																	  R2 = "01011";
																} else {
																	if (instArray[2].equalsIgnoreCase("$d0")) {
																		  R2 = "01100";
																	} else {
																		if (instArray[2].equalsIgnoreCase("$d1")) {
																			  R2 = "01101";
																		} else {
																			if (instArray[2].equalsIgnoreCase("$d2")) {
																				  R2 = "01110";
																			} else {
																				if (instArray[2].equalsIgnoreCase("$d3")) {
																					  R2 = "01111";
																				} else {
																					if (instArray[2].equalsIgnoreCase("$d4")) {
																						  R2 = "10000";
																					} else {
																						if (instArray[2].equalsIgnoreCase("$d5")) {
																							  R2 = "10001";
																						} else {
																							if (instArray[2]
																									.equalsIgnoreCase("$r0")) {
																								  R2 = "10010";
																							} else {
																								if (instArray[2]
																										.equalsIgnoreCase("$R2")) {
																									  R2 = "10011";
																								} else {
																									if (instArray[2]
																											.equalsIgnoreCase(
																													"$r2")) {
																										  R2 = "10100";
																									} else {
																										if (instArray[2]
																												.equalsIgnoreCase(
																														"$r3")) {
																											  R2 = "10101";
																										} else {
																											if (instArray[2]
																													.equalsIgnoreCase(
																															"$r4")) {
																												  R2 = "10110";
																											} else {
																												if (instArray[2]
																														.equalsIgnoreCase(
																																"$r5")) {
																													  R2 = "10111";
																												} else {
																													if (instArray[2]
																															.equalsIgnoreCase(
																																	"$y0")) {
																														  R2 = "11000";
																													} else {
																														if (instArray[2]
																																.equalsIgnoreCase(
																																		"$y1")) {
																															  R2 = "11001";
																														} else {
																															if (instArray[2]
																																	.equalsIgnoreCase(
																																			"$y2")) {
																																  R2 = "11010";
																															} else {
																																if (instArray[2]
																																		.equalsIgnoreCase(
																																				"$y3")) {
																																	  R2 = "11011";
																																} else {
																																	if (instArray[2]
																																			.equalsIgnoreCase(
																																					"$y4")) {
																																		  R2 = "11100";
																																	} else {
																																		if (instArray[2]
																																				.equalsIgnoreCase(
																																						"$y5")) {
																																			  R2 = "11101";
																																		} else {
																																			if (instArray[2]
																																					.equalsIgnoreCase(
																																							"$24k")) {
																																				  R2 = "11110";
																																			} else {
																																				if (instArray[2]
																																						.equalsIgnoreCase(
																																								"$zero")) {
																																					  R2 = "11111";
																																				} else {

																																					textPane.setText(textPane.getText()+
																																							"register not available");

																																				}
																																			}
																																		}

																																	}
																																}
																															}

																														}
																													}
																												}

																											}

																										}
																									}
																								}

																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}

							}
						}
					}

					}
					}
				
				if (instArray.length>3) {
					if (isNumeric(instArray[3]))
					{	int number;
					 number = Integer.parseInt(instArray[3]);	
					 R3 = Integer.toBinaryString(number);
					 
					 while(R3.length()<17) {
						 R3 = "0"+R3;
					 }
					}				else {
					if (instArray[3].equalsIgnoreCase("$a0")) {
						  R3 = "00000";
					} else {
						if (instArray[3].equalsIgnoreCase("$a1")) {
							  R3 = "00001";
						} else {
							if (instArray[3].equalsIgnoreCase("$a2")) {
								  R3 = "00010";
							} else {
								if (instArray[3].equalsIgnoreCase("$a3")) {
									  R3 = "00011";
								} else {
									if (instArray[3].equalsIgnoreCase("$a4")) {
										  R3 = "00100";
									} else {
										if (instArray[3].equalsIgnoreCase("$a5")) {
											  R3 = "00101";
										} else {
											if (instArray[3].equalsIgnoreCase("$b0")) {
												  R3 = "00110";
											} else {
												if (instArray[3].equalsIgnoreCase("$b1")) {
													  R3 = "00111";
												} else {
													if (instArray[3].equalsIgnoreCase("$b2")) {
														  R3 = "01000";
													} else {
														if (instArray[3].equalsIgnoreCase("$b3")) {
															  R3 = "01001";
														} else {
															if (instArray[3].equalsIgnoreCase("$b4")) {
																  R3 = "01010";
															} else {
																if (instArray[3].equalsIgnoreCase("$b5")) {
																	  R3 = "01011";
																} else {
																	if (instArray[3].equalsIgnoreCase("$d0")) {
																		  R3 = "01100";
																	} else {
																		if (instArray[3].equalsIgnoreCase("$d1")) {
																			  R3 = "01101";
																		} else {
																			if (instArray[3].equalsIgnoreCase("$d2")) {
																				  R3 = "01110";
																			} else {
																				if (instArray[3].equalsIgnoreCase("$d3")) {
																					  R3 = "01111";
																				} else {
																					if (instArray[3].equalsIgnoreCase("$d4")) {
																						  R3 = "10000";
																					} else {
																						if (instArray[3].equalsIgnoreCase("$d5")) {
																							  R3 = "10001";
																						} else {
																							if (instArray[3]
																									.equalsIgnoreCase("$r0")) {
																								  R3 = "10010";
																							} else {
																								if (instArray[3]
																										.equalsIgnoreCase("$R3")) {
																									  R3 = "10011";
																								} else {
																									if (instArray[3]
																											.equalsIgnoreCase(
																													"$R3")) {
																										  R3 = "10100";
																									} else {
																										if (instArray[3]
																												.equalsIgnoreCase(
																														"$r3")) {
																											  R3 = "10101";
																										} else {
																											if (instArray[3]
																													.equalsIgnoreCase(
																															"$r4")) {
																												  R3 = "10110";
																											} else {
																												if (instArray[3]
																														.equalsIgnoreCase(
																																"$r5")) {
																													  R3 = "10111";
																												} else {
																													if (instArray[3]
																															.equalsIgnoreCase(
																																	"$y0")) {
																														  R3 = "11000";
																													} else {
																														if (instArray[3]
																																.equalsIgnoreCase(
																																		"$y1")) {
																															  R3 = "11001";
																														} else {
																															if (instArray[3]
																																	.equalsIgnoreCase(
																																			"$y2")) {
																																  R3 = "11010";
																															} else {
																																if (instArray[3]
																																		.equalsIgnoreCase(
																																				"$y3")) {
																																	  R3 = "11011";
																																} else {
																																	if (instArray[3]
																																			.equalsIgnoreCase(
																																					"$y4")) {
																																		  R3 = "11100";
																																	} else {
																																		if (instArray[3]
																																				.equalsIgnoreCase(
																																						"$y5")) {
																																			  R3 = "11101";
																																		} else {
																																			if (instArray[3]
																																					.equalsIgnoreCase(
																																							"$24k")) {
																																				  R3 = "11110";
																																			} else {
																																				if (instArray[3]
																																						.equalsIgnoreCase(
																																								"$zero")) {
																																					  R3 = "11111";
																																				} else {

																																					textPane.setText(textPane.getText()+
																																							"register not available");

																																				}
																																			}
																																		}

																																	}
																																}
																															}

																														}
																													}
																												}

																											}

																										}
																									}
																								}

																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}}
												}
											}
										}
									}
								}

							}
						}
					}

		          
					}
				
				if (instArray.length>4) {
					textPane.setText(textPane.getText()+"invalid instruction length");  
				}
				

				
				if (instArray.length==1) {
					instToBits = "01111000000000000000000000000000";
				}else {
					if (instArray.length==2 && R1.length()!=27) {
						instToBits= opcode+ R1 + "0000000000000000000000";
					}
					else { if (instArray.length ==2 && R1.length()==27)
						
						{instToBits= opcode+ R1 ;
						textPane.setText(instToBits);
						
					System.out.println(instToBits);}
						else {
					}
						if (instArray.length==3 && R2.length()!=22) {
							instToBits = opcode+R1+R2+"00000000000000000";
						}else {
							if  (instArray.length==3 && R2.length()==22) {
								instToBits = opcode+R1+R2;
							}else {
							if (instArray.length==4 && R3.length()!=17) {
								instToBits=opcode+R1+R2+R3+"000000000000";
							} else {
								if (instArray.length==4 && R3.length()==17) {
									instToBits=opcode+R1+R2+R3;
								} 
							
						}
					}
						
				}}}
				instructionList.add(instToBits);
				string.add(instruction);
                textPane.setText(string.toString());
				
				
		            
		    
			
				
			}
		});
		panel.add(btnAddToList, "2, 14");

	
		JButton btnRunButton = new JButton("run");
		btnRunButton.setBackground(new Color(176, 196, 222));
		btnRunButton.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 15));
		panel.add(btnRunButton, "2, 16");
		

		btnRunButton.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
	    	
	    	simulation.setInstructions(instructionList);
	    	simulation.go();

	    }	 
	    });
		
		
	}
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		
		gui window = new gui();
		window.frame.setVisible(true);
	}




}
