package com.suru.j8.test.interfaces;

interface Hotel {
	default public String getHotel() {
		return "HOTEL";
	}

	default public String getName() {
		return "JIMMY";
	}

	static public String sta() {
		return "HO";
	}
}

interface Motel {
	default public String getMotel() {
		return "MOTEL";
	}

	default public String getName() {
		return "AMY";
	}

	static public String sta() {
		return "MO";
	}

}

public class TestingInheritance {

	public static void main(String[] args) {
		class HotelMotel implements Hotel, Motel {

			@Override
			public String getName() {
				return "Combine";
			}
		}

		HotelMotel hotelMotel = new HotelMotel();
		System.out.println(hotelMotel.getHotel());
		System.out.println(hotelMotel.getMotel());
		System.out.println(hotelMotel.getName());
	}

}
