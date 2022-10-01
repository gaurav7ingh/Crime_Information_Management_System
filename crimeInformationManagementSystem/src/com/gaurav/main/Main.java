package com.gaurav.main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.text.html.parser.Element;

import com.gaurav.app.UserInterface;
import com.gaurav.bean.Crime;
import com.gaurav.bean.Criminal;
import com.gaurav.bean.User;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;
import com.gaurav.usecase.AddCrime;
import com.gaurav.usecase.AddCriminal;
import com.gaurav.usecase.AddNewUser;
import com.gaurav.usecase.CrimeByDate;
import com.gaurav.usecase.CrimesByCriminalId;
import com.gaurav.usecase.FindSolvedCase;
import com.gaurav.usecase.FindUnsolvedCases;
import com.gaurav.usecase.SearchCrimeByCaseNo;
import com.gaurav.usecase.SearchCrimesbyArea;
import com.gaurav.usecase.SearchCriminalById;
import com.gaurav.usecase.SearchCriminalByName;
import com.gaurav.usecase.UpdateCrimeStatus;

public class Main {

	public static void main(String[] args) {
		CrimeDao dao = new CrimeDaoImpl();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Your email : ");
		String email = sc.next();
		System.out.println("Enter Your Password : ");
		String pass = sc.next();

		User user = null;
		try {
			user = dao.getUser(email, pass);
		} catch (CrimeException e) {
			System.out.println(e.getMessage());
		}

		if (user != null) {

			boolean flag = true;

			System.out.println("===========================================================================");
			UserInterface.userInterface(user);

			while (flag) {

				System.out.println("\n===========================================================================");
				System.out.println("===========================================================================");
				System.out.println("01. Add New Crime");
				System.out.println("02. Add New Criminal");
				System.out.println("03. All Unsolved Cases");
				System.out.println("04. All Solved Cases");
				System.out.println("05. All Cases");
				System.out.println("06. Search Crime by Case No");
				System.out.println("07. Search Crimes by Area");
				System.out.println("08. Search Crimes by Criminal id");
				System.out.println("09. Search Crime by Date");
				System.out.println("10. Search Criminal by Criminal id");
				System.out.println("11. Search Criminal by Criminal Name");
				System.out.println("12. Update Crime Status to soved by case id");
				System.out.println("13. Add new Officer");
				System.out.println("00. End The App");
				System.out.println("===========================================================================\n");

				System.out.println("Enter The Suitable Number");

				

				// this is creation of objects which is needed
				FindUnsolvedCases fuc = new FindUnsolvedCases(user);
				FindSolvedCase fsc = new FindSolvedCase(user);
				AddCrime addCrime = new AddCrime();
				try {
					int action = sc.nextInt();
					switch (action) {
					case 1:
						try {
							addCrime.main(sc);
						} catch (NumberFormatException e) {
							System.out.println();
							System.out.println("Please enter the key ");

							System.out.println("In case you don't know the id of the criminal you can search by name");
							System.out.println("go to 09. number");
							System.out.println();
						}
						break;

					case 2:
						AddCriminal.main();
						break;

					case 3:
						List<Crime> unsolvedCrimes = fuc.getUnsolvedCasesList();
						unsolvedCrimes.forEach(s -> System.out.println(s));
						break;

					case 4: {
						List<Crime> crimes = fsc.getSolvedCasesList();
						crimes.forEach(s -> System.out.println(s));
						break;
					}

					case 5:
						List<Crime> unsolvedCrime = fuc.getUnsolvedCasesList();
						List<Crime> sovedCrime = fsc.getSolvedCasesList();
						List<Crime> allCrime = new ArrayList<>();
						allCrime.addAll(unsolvedCrime);
						allCrime.addAll(sovedCrime);
						allCrime.forEach(s -> System.out.println(s));
						break;

					case 6:
						System.out.println("Enter the Case No..");
						int caseNo = sc.nextInt();
						SearchCrimeByCaseNo sccn = new SearchCrimeByCaseNo(user, caseNo);
						Crime crime = sccn.getCrime();
						if (crime != null)
							System.out.println(crime);
						else
							System.out.println(sccn.getMsg());
						break;
						
					case 7:
						System.out.println("Enter the Area You want to search..");
						String area = sc.next();
						SearchCrimesbyArea scba = new SearchCrimesbyArea(area);
						if (scba.getSize() == -1)
							System.out.println(scba.getMsg());
						else {
							List<Crime> crimes = scba.getCrimes();
							crimes.forEach(s -> System.out.println(s));
						}
						break;
						
					case 8:
						{System.out.println("Enter the Criminal Id..");
						int criminalId = sc.nextInt(); 
						CrimesByCriminalId cbci = new CrimesByCriminalId(criminalId);
						if(cbci.getSize()==-1) System.out.println(cbci.getMsg());
						else {
							List<Crime> crimes = cbci.getCrimes();
							crimes.forEach(s->System.out.println(s));
						}}
						break;
						
					case 9:
						{
						boolean yes = true;
							while(yes) {
								System.out.println("Enter Date for Search in this format");
								System.out.println("yyyy-mm-dd");
								String pos = sc.next();
								try {
									Date date = Date.valueOf(pos);
									yes = false;
									CrimeByDate cbd = new CrimeByDate(user, date);
									if(cbd.getSize()==-1) System.out.println(cbd.getMsg());
									else {
										List<Crime> crimes = cbd.getCrimes();
										crimes.forEach(s->System.out.println(s));
									}
								}catch (IllegalArgumentException e) {
									System.out.println("Please enter date in right format");
								}
							}
						}
						break;

					case 10:
						{System.out.println("Enter the Criminal Id...");
						int criminalId = sc.nextInt();
						SearchCriminalById scbi = new SearchCriminalById(criminalId);
						Criminal criminal = scbi.getCriminal();
						if (criminal != null)
							System.out.println(criminal);
						else
							System.out.println(scbi.getMsg());}
						break;

					case 11:
						System.out.println("Enter the name of criminal..");
						String name = sc.next();
						SearchCriminalByName scbn = new SearchCriminalByName(name);
						if (scbn.getSize() == -1)
							System.out.println(scbn.getMsg());
						else {
							List<Criminal> criminals = scbn.getCriminals();
							criminals.forEach(s -> System.out.println(s));
						}
						break;

					case 12:
						UpdateCrimeStatus.main();
						break;

					case 13:
						AddNewUser.main();
						break;

					case 0:
						flag = false;
						break;

					default:
						continue;
					}
				} catch (NoSuchElementException e) {
					break;
				}
			}
			System.out.println("Thanks for Visiting");

		}

		sc.close();
	}
}
