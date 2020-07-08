-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 08, 2020 at 08:20 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo_kelompok`
--

-- --------------------------------------------------------

--
-- Table structure for table `info`
--

CREATE TABLE `info` (
  `id` int(11) NOT NULL,
  `tanggal` varchar(255) NOT NULL,
  `judul` varchar(255) NOT NULL,
  `isi_info` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `info`
--

INSERT INTO `info` (`id`, `tanggal`, `judul`, `isi_info`) VALUES
(3, '04-07-2020', 'Teknologi cek covid jarak jauh', 'teknologi ini dinamakan dengan...'),
(5, '08-07-2020', 'Jumlah Sembuh meningkat', 'sudah banyak yang sembuh akibat corona, semoga ini cepat berakhir.');

-- --------------------------------------------------------

--
-- Table structure for table `odp`
--

CREATE TABLE `odp` (
  `id` int(11) NOT NULL,
  `tanggal` varchar(255) NOT NULL,
  `jumlah` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `odp`
--

INSERT INTO `odp` (`id`, `tanggal`, `jumlah`) VALUES
(2, '08-07-2020', '66112 orang');

-- --------------------------------------------------------

--
-- Table structure for table `pdp`
--

CREATE TABLE `pdp` (
  `id` int(11) NOT NULL,
  `tanggal` varchar(255) NOT NULL,
  `jumlah` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pdp`
--

INSERT INTO `pdp` (`id`, `tanggal`, `jumlah`) VALUES
(1, '08-07-2020', '13000 orang');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id` int(11) NOT NULL,
  `nik` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `tanggal_lahir` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `peran` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id`, `nik`, `nama`, `gender`, `tanggal_lahir`, `email`, `password`, `alamat`, `peran`) VALUES
(8, '112', 'gebi', 'wanita', '29-09-2000', 'admin@gmail.com', 'gebi123', 'amsterdam', 'admin'),
(17, '3433', 'gebo', 'pria', '29-08-2000', 'gebo@gmail.com', 'gebo123', 'depok', 'masyarakat'),
(21, '11418', 'Sion', 'pria', '26-05-2000', 'sion@gmail.com', 'sion', 'hutagalung', 'admin'),
(22, '11418040', 'Lamhot', 'pria', '26-05-2000', 'lamhot@gmail.com', 'lamhot', 'Siraja hutagalung', 'masyarakat'),
(23, '13213', 'Sion Pardede', 'pria', '26-05-2000', 'pardedesion@gmail.com', 'sion2605', 'Hutagalung', 'admin'),
(24, '321321', 'masyarakat', 'pria', '20-09-2000', 'mas@gmail.com', 'mas', 'dimana', 'masyarakat');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `info`
--
ALTER TABLE `info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `odp`
--
ALTER TABLE `odp`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pdp`
--
ALTER TABLE `pdp`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `info`
--
ALTER TABLE `info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `odp`
--
ALTER TABLE `odp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pdp`
--
ALTER TABLE `pdp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
