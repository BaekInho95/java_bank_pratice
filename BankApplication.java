package lenshu1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	
	//매뉴 선택 명령어를 상수로 초기화
	static final int createAccount = 1;
	static final int accountList = 2;
	static final int deposit = 3;
	static final int withdraw = 4;
	static final int exit = 5;



	public static void main(String[] args) throws IOException {
		boolean run = true;
		while(run) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("1. 생성, 2. 목록, 3.예금, 4.출금, 5.종료");
			System.out.print("선택");
			
			//string으로 받은 br을 int로 변환해서 selectNo에 저장
			int selectNo =  Integer.parseInt(br.readLine());
			
			if(selectNo == createAccount) {
				createAccount();
			} else if(selectNo == accountList) {
				accountList();
			} else if(selectNo == deposit) {
				deposit();
			} else if(selectNo == withdraw) {
				withdraw();
			} else if(selectNo == exit) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
		

	}

	private static void withdraw() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("출금 클래스");	
		System.out.println("");
		
		System.out.print("계좌번호 입력");
		String ano = br.readLine();
		Account account = findAccount(ano);
		if(account == null) {
			System.out.println("없는 계좌");
			return;
		}
		System.out.print("출금액: ");
		int balance = Integer.parseInt(br.readLine());
		account.setBalance(account.getBalance() - balance);
		System.out.println("출금완료");
		System.out.println("");


	}
	
	private static void deposit() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("예금 클래스");		
		System.out.println("");
		
		System.out.print("계좌번호 입력");
		String ano = br.readLine();
		Account account = findAccount(ano);
		if(account == null) {
			System.out.println("없는 계좌");
			return;
		}
		System.out.print("예금액: ");
		int balance = Integer.parseInt(br.readLine());
		account.setBalance(account.getBalance() + balance);
		System.out.println("예금완료");
		System.out.println("");

	}

	private static void accountList(){
		System.out.println("계좌 목록 클래스");
		System.out.println("");

		for(int i =0; i<accountArray.length ; i++) {
			if(accountArray[i] != null) {
				System.out.println((i+1) + "번 계좌");
				System.out.println("계좌번호: "+accountArray[i].getAno());
				System.out.println("계좌주: "+accountArray[i].getOwner());
				System.out.println("초기입금액 "+accountArray[i].getBalance());
				System.out.println("");
				
			}

			
			
		}
	}

	private static void createAccount() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("계좌 생성 클래스");
		System.out.println("");

		
		System.out.print("계좌번호:");
		String ano = br.readLine();
		System.out.print("계좌주:");
		String owner = br.readLine();
		System.out.print("초기입금액:");
		int balance = Integer.parseInt(br.readLine());
		
		Account account = new Account(ano, owner, balance);
		
		for(int i = 0; i<accountArray.length; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = account;
				System.out.println("계좌 생성 완료");
				System.out.println("계좌번호: "+accountArray[i].getAno());
				System.out.println("계좌주: "+accountArray[i].getOwner());
				System.out.println("초기입금액 "+accountArray[i].getBalance());
				break;
			}
		}
		System.out.println("");
		
	}
	
	private static Account findAccount(String ano) {
		Account findAccount = null;
		for(int i = 0; i < accountArray.length ; i++) {
			if(accountArray[i] != null) {
				if(accountArray[i].getAno().equals(ano)) {
					findAccount = accountArray[i] ;
					break;
				}
			}
			
		}
		return findAccount;
		
	}

}
