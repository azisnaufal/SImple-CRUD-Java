/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 10.1.24-MariaDB : Database - db_makanan_kesukaan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_makanan_kesukaan` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_makanan_kesukaan`;

/*Table structure for table `tb_kelas` */

DROP TABLE IF EXISTS `tb_kelas`;

CREATE TABLE `tb_kelas` (
  `id_kelas` int(3) NOT NULL AUTO_INCREMENT,
  `kelas` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_kelas`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `tb_kelas` */

insert  into `tb_kelas`(`id_kelas`,`kelas`) values 
(1,'XII-RPL3'),
(2,'XI-RPL3'),
(3,'X-RPL3'),
(4,'X-MM'),
(5,'XI-TITL2'),
(8,'XI-MM2');

/*Table structure for table `tb_makanan` */

DROP TABLE IF EXISTS `tb_makanan`;

CREATE TABLE `tb_makanan` (
  `id_makanan` int(3) NOT NULL AUTO_INCREMENT,
  `makanan` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_makanan`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `tb_makanan` */

insert  into `tb_makanan`(`id_makanan`,`makanan`) values 
(1,'Cauliflower'),
(2,'Roti'),
(3,'Spaghetti'),
(4,'Nasi Kuning'),
(5,'Nasi Uduk');

/*Table structure for table `tb_siswa` */

DROP TABLE IF EXISTS `tb_siswa`;

CREATE TABLE `tb_siswa` (
  `nis` varchar(11) NOT NULL,
  `nama` varchar(60) DEFAULT NULL,
  `id_kelas` int(3) DEFAULT NULL,
  `id_makanan` int(3) DEFAULT NULL,
  PRIMARY KEY (`nis`),
  KEY `id_makanan` (`id_makanan`),
  KEY `id_kelas` (`id_kelas`),
  CONSTRAINT `tb_siswa_ibfk_1` FOREIGN KEY (`id_makanan`) REFERENCES `tb_makanan` (`id_makanan`),
  CONSTRAINT `tb_siswa_ibfk_2` FOREIGN KEY (`id_kelas`) REFERENCES `tb_kelas` (`id_kelas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_siswa` */

insert  into `tb_siswa`(`nis`,`nama`,`id_kelas`,`id_makanan`) values 
('1516 116239','ADITIA DWI PRATOMO',1,1),
('1516 116240','AGHNIA NUR JANNAH',1,2),
('1516 116241','ANDIKA MUHAMMAD REZKA',1,3),
('1516 116242','ARHAM DADIAMAR',1,4),
('1516 116243','AZIS NAUFAL',1,5),
('1516 116244','BILLY YEREMIA EFRAT',1,1),
('1516 116245','CHANDIKA NURDIANSYAH',1,2),
('1516 116246','CHYNTIA MAHARANI',1,3),
('1516 116247','DAUD RIFKI GUNAWAN',1,1),
('1516 116248','DEFFIN ACHMAD DIFA',1,4),
('1516 116249','DERI ASYKARI',1,2),
('1516 116250','DIKANIO LADIKA SAPUTRA',1,4),
('1516 116251','FAJAR EGA FIRMANSYAH',1,1),
('1516 116252','FITRI KURNIA MULYANI',1,3),
('1516 116253','HAFIDZ AWALUDDIN WAHYU',1,5),
('1516 116254','IRFAN NURHAKIM',1,5),
('1516 116255','IRVAN LUTFI GUNAWAN',1,1),
('1516 116256','JALU NUGROHO',1,2),
('1516 116257','LUTHFI IMAM MAULANA',1,3),
('1516 116258','MIKA MILENIUS',1,3),
('1516 116259','MOCH. RIZKY JANUAR RAMADHAN',1,3),
('1516 116260','MOHAMAD FIKRI FAKHRIYAN',1,3),
('1516 116261','MUHAMAD FEBRIAN FAUZI AL FANDI',1,4),
('1516 116262','MUHAMMAD IQBAL MAWARDI',1,2),
('1516 116263','MUHAMMAD IRFAN FAKHRI',1,3),
('1516 116264','MUHAMMAD NAUFAL FADHILAH',1,4),
('1516 116265','MUHAMMAD RAFI SHALAHUDIN',1,3),
('1516 116266','MUHAMMAD RIZKY ARIFIN',1,2),
('1516 116267','NAUFAL ZAIN SUSANTO',1,1),
('1516 116268','RIKSA SUVIANA ROCHMAN',1,2),
('1516 116269','RIZKI MAULADI',1,5),
('1516 116271','THARIQ FATHAN MUBIINA',1,1),
('1516 116272','USEP SUMARYANA',1,2),
('1516 116274','YUDA SYAHRIZAL MADANI',1,3),
('1516 166270','SANDI SETIAWAN',1,4),
('1516116273','WIDIYANTO',1,5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
