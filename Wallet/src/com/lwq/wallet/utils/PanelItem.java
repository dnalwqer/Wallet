package com.lwq.wallet.utils;

public class PanelItem {
	public int ImgItem;
	public String TitleItem;
	public int color;
	
	public void setTitle(int ImgItem,String TitleItem,int color){
		this.ImgItem=ImgItem;
		this.TitleItem=TitleItem;
		this.color=color;
	}
	
	public int getImgItem() {
		return ImgItem;
	}
	public String getTitleItem() {
		return TitleItem;
	}
	
	public int getColor(){
		return color;
	}
}
