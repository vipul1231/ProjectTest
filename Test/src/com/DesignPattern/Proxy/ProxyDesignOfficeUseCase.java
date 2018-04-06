package com.DesignPattern.Proxy;


interface Cashable{
	void cashedToAmount();
}

class CashChips implements Cashable{
	
	enum ChipType {CASHABLE};
	String chipType;
	int value;
	
	public CashChips(ChipType ch, int value) {
		// TODO Auto-generated constructor stub
		this.chipType = ch.name();
		this.value = value;
	}

	@Override
	public void cashedToAmount() {
		// TODO Auto-generated method stub
		System.out.println("Chips amounting Rs. "+value+" are cashed. Thank you for playing");
	}
}


class PromoChips implements Cashable {
	
	enum ChipType {LUCKY_CHIP,VOUCHER_CHIPS,RANDOM_CHIPS};
	CashChips cashChips;
	String chipType;
	int value;
	
	public PromoChips(ChipType ch, int value) {
		// TODO Auto-generated constructor stub
		chipType = ch.name();
		this.value = value;
	}
	
	@Override
	public void cashedToAmount() {
		// TODO Auto-generated method stub
		
		if(criteriaForEncashing()){
			cashChips = new CashChips(com.DesignPattern.Proxy.CashChips.ChipType.CASHABLE, value);
			cashChips.cashedToAmount();
		}
		else {
			System.out.println("System Error. Chips for amount "+value+" cannot be cashed.");
		}
		
	}

	private boolean criteriaForEncashing(){
		
		if(chipType.equals("LUCKY_CHIP")){
			return true;
		}
		else {
			return false;
		}
	}
}



public class ProxyDesignOfficeUseCase {
	
	public static void main(String[] args){
		Cashable chips1 = new CashChips(com.DesignPattern.Proxy.CashChips.ChipType.CASHABLE,1000);
		chips1.cashedToAmount();
		Cashable chips2 = new PromoChips(com.DesignPattern.Proxy.PromoChips.ChipType.LUCKY_CHIP, 134);
		chips2.cashedToAmount();
		Cashable chips3 = new PromoChips(com.DesignPattern.Proxy.PromoChips.ChipType.VOUCHER_CHIPS, 120);
		chips3.cashedToAmount();
		
	}
}
