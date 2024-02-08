package com.hexaware.dao;


import com.hexaware.entity.Reservation;
import com.hexaware.exception.ReservationException;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public interface IReservationService {

	boolean createReservation(IReservationService reservationService);
	Reservation getReservationById(int reservationId)throws ReservationException;
	void updateReservation(Reservation reservationData);
	void cancelReservation(int reservationId)throws ReservationException ;
	List<Reservation> getReservationByCustomerId(int reservationId) throws ReservationException;
	void getReservationsByVehicleId();
}
