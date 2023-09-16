/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.29 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `theater` (
	`movie_id` int (11),
	`movie_name` varchar (90),
	`movie_theater` varchar (90),
	`no_of_tickets_available` int (11),
	`price_per_ticket` int (11)
); 
insert into `theater` (`movie_id`, `movie_name`, `movie_theater`, `no_of_tickets_available`, `price_per_ticket`) values('1','AVTAR','INOX','95','249');
insert into `theater` (`movie_id`, `movie_name`, `movie_theater`, `no_of_tickets_available`, `price_per_ticket`) values('2','LIFE OF PIE','CIEPOLIS','145','349');
insert into `theater` (`movie_id`, `movie_name`, `movie_theater`, `no_of_tickets_available`, `price_per_ticket`) values('3','AVENGERS END GAME','CITY PRIDE','130','199');
insert into `theater` (`movie_id`, `movie_name`, `movie_theater`, `no_of_tickets_available`, `price_per_ticket`) values('4','ANABELLA','PVR','85','249');
insert into `theater` (`movie_id`, `movie_name`, `movie_theater`, `no_of_tickets_available`, `price_per_ticket`) values('5','CONJURING 3','CARNIVAL CINEMAS','150','211');
