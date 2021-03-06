-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 08-07-2018 a las 01:06:41
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `portal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acciones_pagina`
--

CREATE TABLE `acciones_pagina` (
  `ID_ACCION` int(11) NOT NULL,
  `ID_PAGINA` int(11) NOT NULL,
  `ACCION` varchar(200) DEFAULT NULL,
  `ACTIVA` int(11) DEFAULT NULL,
  `DESCRIPCION` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargue_archivos`
--

CREATE TABLE `cargue_archivos` (
  `ID_CARGUE` int(11) NOT NULL,
  `ID_CLIENTE` int(11) NOT NULL,
  `NOMBRE_ARCHIVO` varchar(40) NOT NULL,
  `FECHA_CARGUE` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cargue_archivos`
--

INSERT INTO `cargue_archivos` (`ID_CARGUE`, `ID_CLIENTE`, `NOMBRE_ARCHIVO`, `FECHA_CARGUE`) VALUES
(32, 1, 'PLANTILLA_CARGUE.xlsx', '2018-07-01 19:17:29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `ID_CLIENTE` int(11) NOT NULL,
  `NIT` int(11) DEFAULT NULL,
  `NOMBRE` varchar(200) DEFAULT NULL,
  `CORREO` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`ID_CLIENTE`, `NIT`, `NOMBRE`, `CORREO`) VALUES
(1, 1144167624, 'JOHN A PANTOJA DIAZ', NULL),
(2, 1144168383, 'DIEGO', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_usuario`
--

CREATE TABLE `cliente_usuario` (
  `ID_CLIENTE_USUARIO` int(11) NOT NULL,
  `ID_CLIENTE` int(11) NOT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  `CEDULA` int(11) DEFAULT NULL,
  `TIPO_DOC` int(11) DEFAULT NULL,
  `PRIMER_NOMBRE` varchar(100) DEFAULT NULL,
  `SEGUNDO_NOMBRE` varchar(100) DEFAULT NULL,
  `PRIMER_APELLIDO` varchar(100) DEFAULT NULL,
  `SEGUNDO_APELLIDO` varchar(100) DEFAULT NULL,
  `DIRECCION` varchar(500) DEFAULT NULL,
  `CIUDAD` varchar(100) DEFAULT NULL,
  `DEPARTAMENTO` varchar(100) DEFAULT NULL,
  `TELEFONO_1` varchar(40) DEFAULT NULL,
  `TELEFONO_2` varchar(40) DEFAULT NULL,
  `TELEFONO_3` varchar(40) DEFAULT NULL,
  `CELULAR` varchar(40) DEFAULT NULL,
  `CORREO` varchar(200) DEFAULT NULL,
  `FECHA_ACTUALIZACION` datetime DEFAULT NULL,
  `ESTADO` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente_usuario`
--

INSERT INTO `cliente_usuario` (`ID_CLIENTE_USUARIO`, `ID_CLIENTE`, `ID_USUARIO`, `CEDULA`, `TIPO_DOC`, `PRIMER_NOMBRE`, `SEGUNDO_NOMBRE`, `PRIMER_APELLIDO`, `SEGUNDO_APELLIDO`, `DIRECCION`, `CIUDAD`, `DEPARTAMENTO`, `TELEFONO_1`, `TELEFONO_2`, `TELEFONO_3`, `CELULAR`, `CORREO`, `FECHA_ACTUALIZACION`, `ESTADO`) VALUES
(108, 2, 168, 10002841, 1, 'FRANKLIN', '', 'RENTERIA', 'SERNA', 'TORRE GDOS APTO 493 SALAMANCA', 'PEREIRA', 'RISARALDA', '3103836859', '3206352198', '0', '3206352198', '9713RESTREPO@GMAIL.COM', '2018-07-01 19:17:29', 'ACTIVO'),
(109, 2, 169, 10006171, 1, 'JOSE', 'JULIAN', 'DURAN', 'CASTRO', 'MZ 28 CA 39 EL REMANZO VILLA SANTANA', 'PEREIRA', 'RISARALDA', '3209100533', '0', '0', '3209100533', 'diegoluis1993@gmail.com', '2018-07-01 19:17:34', 'ACTIVO'),
(110, 2, 170, 10006924, 1, 'STEVENS', '', 'RODRIGUEZ', 'HOLGUIN', 'KR 19 71 A 35', 'CALI', 'VALLE', '3188535637', '3176999947', '1', '0', '903.mauricio@gmail.com', '2018-07-01 19:17:37', 'ACTIVO'),
(111, 2, 171, 1000870241, 1, 'WENDY', 'VANESA', 'MORENO', 'SALAS', 'KR 26 H 2  122  104  PISO 2', 'CALI', 'VALLE', '3226610364', '22', '0', '3166935070', '90MAICOLSMITH@GNMAIL.COM', '2018-07-01 19:17:37', 'ACTIVO'),
(112, 2, 172, 1000930458, 1, 'JOHN', 'ALEXANDRA', 'VARELA', 'sila', 'CR 4 8 23 COSTA RICA', 'GINEBRA', 'VALLE', '3127102010', '0', '0', '3127102010', '8985316@yahoo.com', '2018-07-01 19:17:39', 'ACTIVO'),
(113, 2, 173, 10012624, 1, 'CALIXTO', '', 'MOSQUERA', 'CORDOBA', 'MZ 27  CA 2 SECTOR A PARQUE INDUSTRIAL', 'PEREIRA', 'RISARALDA', '3128245970', '0', '0', '0', '88706@hotmail.com', '2018-07-01 19:17:42', 'ACTIVO'),
(114, 2, 174, 1001283419, 1, 'ALEJANDRO', '', 'MARQUEZ', '', 'CL 32 25 75', 'EL CERRITO', 'VALLE', '3156609902', '3206181270', '0', '3156609902', '8819DEREK@GMAIL.COM', '2018-07-01 19:17:45', 'ACTIVO'),
(115, 2, 175, 10013708, 1, 'ANGEL', 'ANDRES', 'LOPEZ', 'HENAO', 'CLL 43a  2 48', 'PEREIRA', 'RISARALDA', '3137382247', '3116122872', '0', '3137382247', '87florv@gmail.com', '2018-07-01 19:17:47', 'ACTIVO'),
(116, 2, 176, 10013715, 1, 'GENARO', '', 'VANEGAS', 'BURGOS', 'MZ K CS 5 LOS ROBLES', 'MONTENEGRO', 'QUINDIO', '3215891216', '3113697922', '0', '3215891216', '821JHONJAIRO@GMAIL.COM', '2018-07-01 19:17:53', 'ACTIVO'),
(117, 2, 177, 10014154, 1, 'JHON', 'FREDY', 'RIOS', 'COLORADO', 'MZ 3 CA 51 PISO2 JOSE MARIA CORDOBA', 'MONTENEGRO', 'QUINDIO', '3148029540', '0', '0', '2', '8W_RAMIREZ@HOTMAIL.COM', '2018-07-01 19:17:53', 'ACTIVO'),
(118, 2, 178, 10014939, 1, 'JHON', 'FREDY', 'HUILA', 'MAPURA', 'MZ 1 CA 19 2 PISO VILLAELENA CUBA', 'PEREIRA', 'RISARALDA', '3216199941', '3396467', '0', '22', '8JDAVID23@HOTMIAL.COM', '2018-07-01 19:17:56', 'ACTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compromiso`
--

CREATE TABLE `compromiso` (
  `ID_COMPROMISO` int(11) NOT NULL,
  `ID_OBLIGACION` int(11) NOT NULL,
  `ORDEN` int(11) DEFAULT NULL,
  `INTERES` varchar(10) DEFAULT NULL,
  `VALOR` int(11) DEFAULT NULL,
  `FECHA_COMPROMISO` varchar(40) DEFAULT NULL,
  `ESTADO` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_cargue`
--

CREATE TABLE `detalle_cargue` (
  `ID_CARGUE` int(11) NOT NULL,
  `NUMERO_TITULO_VALOR` varchar(100) NOT NULL,
  `CUOTA` int(11) NOT NULL,
  `FECHA_ELABORACION` date DEFAULT NULL,
  `VALOR` int(11) DEFAULT NULL,
  `FECHA_VENCIMIENTO` date DEFAULT NULL,
  `DIAS_MORA` int(11) DEFAULT NULL,
  `TIPO_DOC` int(11) DEFAULT NULL,
  `CEDULA` int(11) NOT NULL,
  `PRIMER_NOMBRE` varchar(100) DEFAULT NULL,
  `SEGUNDO_NOMBRE` varchar(100) DEFAULT NULL,
  `PRIMER_APELLIDO` varchar(100) DEFAULT NULL,
  `SEGUNDO_APELLIDO` varchar(100) DEFAULT NULL,
  `DIRECCION` varchar(500) DEFAULT NULL,
  `CIUDAD` varchar(100) DEFAULT NULL,
  `DEPARTAMENTO` varchar(100) DEFAULT NULL,
  `TELEFONO_1` varchar(40) DEFAULT NULL,
  `TELEDONO_2` varchar(40) DEFAULT NULL,
  `TELEFONO_3` varchar(40) DEFAULT NULL,
  `CELULAR` varchar(40) DEFAULT NULL,
  `CORREO` varchar(200) DEFAULT NULL,
  `ESTADO` varchar(40) DEFAULT NULL,
  `MSG_ERROR` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_cargue`
--

INSERT INTO `detalle_cargue` (`ID_CARGUE`, `NUMERO_TITULO_VALOR`, `CUOTA`, `FECHA_ELABORACION`, `VALOR`, `FECHA_VENCIMIENTO`, `DIAS_MORA`, `TIPO_DOC`, `CEDULA`, `PRIMER_NOMBRE`, `SEGUNDO_NOMBRE`, `PRIMER_APELLIDO`, `SEGUNDO_APELLIDO`, `DIRECCION`, `CIUDAD`, `DEPARTAMENTO`, `TELEFONO_1`, `TELEDONO_2`, `TELEFONO_3`, `CELULAR`, `CORREO`, `ESTADO`, `MSG_ERROR`) VALUES
(32, 'FVC-11340-1', 3, '2010-02-12', 43545, '2010-02-12', 21, 1, 1001283419, 'ALEJANDRO', '', 'MARQUEZ', '', 'CL 32 25 75', 'EL CERRITO', 'VALLE', '3156609902', '3206181270', '0', '3156609902', '8819DEREK@GMAIL.COM', NULL, NULL),
(32, 'FVC-12059-12', 9, '2010-02-12', 121400, '2010-02-12', 12, 1, 10013708, 'ANGEL', 'ANDRES', 'LOPEZ', 'HENAO', 'CLL 43a  2 48', 'PEREIRA', 'RISARALDA', '3137382247', '3116122872', '0', '3137382247', '87florv@gmail.com', NULL, NULL),
(32, 'FVC-12328-10', 7, '2010-02-12', 74900, '2010-02-12', 22, 1, 10012624, 'CALIXTO', '', 'MOSQUERA', 'CORDOBA', 'MZ 27  CA 2 SECTOR A PARQUE INDUSTRIAL', 'PEREIRA', 'RISARALDA', '3128245970', '0', '0', '0', '88706@hotmail.com', NULL, NULL),
(32, 'FVC-12667-8', 1, '2010-02-12', 56000, '2010-02-12', 22, 1, 10002841, 'FRANKLIN', '', 'RENTERIA', 'SERNA', 'TORRE GDOS APTO 493 SALAMANCA', 'PEREIRA', 'RISARALDA', '3103836859', '3206352198', '0', '3206352198', '9713RESTREPO@GMAIL.COM', NULL, NULL),
(32, 'FVC-12745-8', 13, '2010-02-12', 57300, '2010-02-12', 4, 1, 10014939, 'JHON', 'FREDY', 'HUILA', 'MAPURA', 'MZ 1 CA 19 2 PISO VILLAELENA CUBA', 'PEREIRA', 'RISARALDA', '3216199941', '3396467', '0', '22', '8JDAVID23@HOTMIAL.COM', NULL, NULL),
(32, 'FVC-12788-6', 12, '2010-02-12', 102600, '2010-02-12', 28, 1, 10014154, 'JHON', 'FREDY', 'RIOS', 'COLORADO', 'MZ 3 CA 51 PISO2 JOSE MARIA CORDOBA', 'MONTENEGRO', 'QUINDIO', '3148029540', '0', '0', '2', '8W_RAMIREZ@HOTMAIL.COM', NULL, NULL),
(32, 'FVC-13759-2', 2, '2010-02-12', 56400, '2010-02-12', 1, 1, 10006171, 'JOSE', 'JULIAN', 'DURAN', 'CASTRO', 'MZ 28 CA 39 EL REMANZO VILLA SANTANA', 'PEREIRA', 'RISARALDA', '3209100533', '0', '0', '3209100533', NULL, NULL, NULL),
(32, 'FVC-16468-3', 10, '2010-02-12', 137400, '2010-02-12', 52, 1, 10013715, 'GENARO', '', 'VANEGAS', 'BURGOS', 'MZ K CS 5 LOS ROBLES', 'MONTENEGRO', 'QUINDIO', '3215891216', '3113697922', '0', '3108488989', 'PEDROHERRERAIMB@HOTMAIL.COM', NULL, NULL),
(32, 'FVC-16468-4', 11, '2010-02-12', 137400, '2010-02-12', 21, 1, 10013715, 'GENARO', '', 'VANEGAS', 'BURGOS', 'MZ K CS 5 LOS ROBLES', 'MONTENEGRO', 'QUINDIO', '3215891216', '3113697922', '0', '3215891216', '821JHONJAIRO@GMAIL.COM', NULL, NULL),
(32, 'FVC-25343-4', 3, '2010-02-12', 89000, '2010-02-12', 49, 1, 10006924, 'STEVENS', '', 'RODRIGUEZ', 'HOLGUIN', 'KR 19 71 A 35', 'CALI', 'VALLE', '3188535637', '3176999947', '0', '0', '95AGUIRRE@GMAIL.COM', NULL, NULL),
(32, 'FVC-25343-5', 4, '2010-02-12', 89000, '2017-02-11', 18, 1, 10006924, 'STEVENS', '', 'RODRIGUEZ', 'HOLGUIN', 'KR 19 71 A 35', 'CALI', 'VALLE', '3188535637', '3176999947', '1', '0', '903.mauricio@gmail.com', NULL, NULL),
(32, 'FVC-43377-2', 5, '2010-02-12', 17000, '2010-02-12', 8, 1, 1000870241, 'WENDY', 'VANESA', 'MORENO', 'SALAS', 'KR 26 H 2  122  104  PISO 2', 'CALI', 'VALLE', '3226610364', '22', '0', '3166935070', '90MAICOLSMITH@GNMAIL.COM', NULL, NULL),
(32, 'FVC-9627-13', 6, '2010-02-12', 97800, '2010-02-12', 18, 1, 1000930458, 'JOHN', 'ALEXANDRA', 'VARELA', 'sila', 'CR 4 8 23 COSTA RICA', 'GINEBRA', 'VALLE', '3127102010', '0', '0', '3127102010', '8985316@yahoo.com', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_obligacion`
--

CREATE TABLE `detalle_obligacion` (
  `ID_DETALLE_OBLI` int(11) NOT NULL,
  `ID_OBLIGACION` int(11) NOT NULL,
  `CUOTA` int(11) DEFAULT NULL,
  `FECHA_ELABORACION` date DEFAULT NULL,
  `FECHA_VENCIMIENTO` date DEFAULT NULL,
  `DIAS_MORA` int(11) DEFAULT NULL,
  `VALOR` int(11) DEFAULT NULL,
  `ESTADO` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_obligacion`
--

INSERT INTO `detalle_obligacion` (`ID_DETALLE_OBLI`, `ID_OBLIGACION`, `CUOTA`, `FECHA_ELABORACION`, `FECHA_VENCIMIENTO`, `DIAS_MORA`, `VALOR`, `ESTADO`) VALUES
(12, 12, 1, '2010-02-12', '2010-02-12', 22, 56000, 'ACTIVO'),
(13, 13, 2, '2010-02-12', '2010-02-12', 1, 56400, 'ACTIVO'),
(14, 14, 3, '2010-02-12', '2010-02-12', 49, 89000, 'ACTIVO'),
(15, 15, 5, '2010-02-12', '2010-02-12', 8, 17000, 'ACTIVO'),
(16, 16, 6, '2010-02-12', '2010-02-12', 18, 97800, 'ACTIVO'),
(17, 17, 7, '2010-02-12', '2010-02-12', 22, 74900, 'ACTIVO'),
(18, 18, 3, '2010-02-12', '2010-02-12', 21, 43545, 'ACTIVO'),
(19, 19, 9, '2010-02-12', '2010-02-12', 12, 121400, 'ACTIVO'),
(20, 20, 10, '2010-02-12', '2010-02-12', 52, 137400, 'ACTIVO'),
(21, 21, 12, '2010-02-12', '2010-02-12', 28, 102600, 'ACTIVO'),
(22, 22, 13, '2010-02-12', '2010-02-12', 4, 57300, 'ACTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_cargue`
--

CREATE TABLE `estado_cargue` (
  `ID_ESTADO_CARGUE` int(11) NOT NULL,
  `ID_PLANTILLA` int(11) NOT NULL,
  `DESCRIPCION` varchar(200) DEFAULT NULL,
  `DIAS` int(11) DEFAULT NULL,
  `ORDEN` int(11) DEFAULT NULL,
  `ACTIVA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_notificacion_cargue`
--

CREATE TABLE `estado_notificacion_cargue` (
  `ID_ESTADO_NOT_CARG` int(11) NOT NULL,
  `ID_CARGUE` int(11) NOT NULL,
  `ID_ESTADO_CARGUE` int(11) NOT NULL,
  `FECHA_CREACION` date DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_notificacion_usuario`
--

CREATE TABLE `estado_notificacion_usuario` (
  `ID_ESTADO_NOT_USU` int(11) NOT NULL,
  `ID_CLIENTE_USUARIO` int(11) NOT NULL,
  `ID_ESTADO_USUARIO` int(11) NOT NULL,
  `FECHA_CREACION` date DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_usuario`
--

CREATE TABLE `estado_usuario` (
  `ID_ESTADO_USUARIO` int(11) NOT NULL,
  `ID_PLANTILLA` int(11) NOT NULL,
  `DESCRIPCION` varchar(200) DEFAULT NULL,
  `DIAS` int(11) DEFAULT NULL,
  `ORDEN` int(11) DEFAULT NULL,
  `ACTIVA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `obligacion`
--

CREATE TABLE `obligacion` (
  `ID_OBLIGACION` int(11) NOT NULL,
  `ID_CLIENTE_USUARIO` int(11) NOT NULL,
  `NUMERO_TITULAR` varchar(100) DEFAULT NULL,
  `ESTADO` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `obligacion`
--

INSERT INTO `obligacion` (`ID_OBLIGACION`, `ID_CLIENTE_USUARIO`, `NUMERO_TITULAR`, `ESTADO`) VALUES
(12, 108, 'FVC-12667-8', 'ACTIVO'),
(13, 109, 'FVC-13759-2', 'ACTIVO'),
(14, 110, 'FVC-25343-4', 'ACTIVO'),
(15, 111, 'FVC-43377-2', 'ACTIVO'),
(16, 112, 'FVC-9627-13', 'ACTIVO'),
(17, 113, 'FVC-12328-10', 'ACTIVO'),
(18, 114, 'FVC-11340-1', 'ACTIVO'),
(19, 115, 'FVC-12059-12', 'ACTIVO'),
(20, 116, 'FVC-16468-3', 'ACTIVO'),
(21, 117, 'FVC-12788-6', 'ACTIVO'),
(22, 118, 'FVC-12745-8', 'ACTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paginas`
--

CREATE TABLE `paginas` (
  `ID_PAGINA` int(11) NOT NULL,
  `PAGINA` varchar(200) DEFAULT NULL,
  `ACTIVA` int(11) DEFAULT NULL,
  `DESCRIPCION` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos_usuarios`
--

CREATE TABLE `permisos_usuarios` (
  `ID_PERMISO` int(11) NOT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  `ID_ACCION` int(11) NOT NULL,
  `ACTIVO` int(11) DEFAULT NULL,
  `USU_ASIGNACION` int(11) DEFAULT NULL,
  `FECHA_ASIGNACION` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plantillas_email`
--

CREATE TABLE `plantillas_email` (
  `ID_PLANTILLA` int(11) NOT NULL,
  `DESCRIPCION` varchar(4000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesiones_activas`
--

CREATE TABLE `sesiones_activas` (
  `ID_SESION` int(11) NOT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  `ACTIVO` int(11) DEFAULT NULL,
  `FECHA_INGRESO` datetime DEFAULT NULL,
  `FECHA_ULTIMA_ACT` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sesiones_activas`
--

INSERT INTO `sesiones_activas` (`ID_SESION`, `ID_USUARIO`, `ACTIVO`, `FECHA_INGRESO`, `FECHA_ULTIMA_ACT`) VALUES
(42, 1, 1, '2018-07-01 18:53:35', '2018-07-01 18:53:35'),
(43, 1, 1, '2018-07-01 19:16:48', '2018-07-01 19:16:48'),
(44, 1, 0, '2018-07-01 19:44:36', '2018-07-01 19:44:36'),
(45, 1, 0, '2018-07-01 19:45:02', '2018-07-01 19:45:02'),
(46, 1, 0, '2018-07-01 19:50:06', '2018-07-01 19:50:06'),
(47, 1, 1, '2018-07-01 20:58:16', '2018-07-01 20:58:16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `token`
--

CREATE TABLE `token` (
  `ID_TOKEN` int(11) NOT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  `TOKEN` varchar(40) DEFAULT NULL,
  `FECHA_INICIO` datetime DEFAULT NULL,
  `FECHA_FIN` datetime DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `token`
--

INSERT INTO `token` (`ID_TOKEN`, `ID_USUARIO`, `TOKEN`, `FECHA_INICIO`, `FECHA_FIN`, `ACTIVO`) VALUES
(89, 168, '6b3bbe2f', '2018-07-01 19:17:29', '2018-07-01 22:17:29', 1),
(90, 169, 'b3949f1c', '2018-07-01 19:17:34', '2018-07-01 22:17:34', 1),
(91, 170, 'bf433774', '2018-07-01 19:17:34', '2018-07-01 22:17:34', 1),
(92, 171, '16089g2e', '2018-07-01 19:17:37', '2018-07-01 22:17:37', 1),
(93, 172, '2gg6f553', '2018-07-01 19:17:39', '2018-07-01 22:17:39', 1),
(94, 173, '2b469724', '2018-07-01 19:17:42', '2018-07-01 22:17:42', 1),
(95, 174, '16bea996', '2018-07-01 19:17:45', '2018-07-01 22:17:45', 1),
(96, 175, '2c3g0a33', '2018-07-01 19:17:47', '2018-07-01 22:17:47', 1),
(97, 176, '559f2114', '2018-07-01 19:17:50', '2018-07-01 22:17:50', 1),
(98, 177, '1fcbe64c', '2018-07-01 19:17:53', '2018-07-01 22:17:53', 1),
(99, 178, '1087f2de', '2018-07-01 19:17:56', '2018-07-01 22:17:56', 1),
(100, 169, '272dd0dc', '2018-07-01 20:53:11', '2018-07-01 23:53:11', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID_USUARIO` int(11) NOT NULL,
  `CEDULA` int(11) NOT NULL,
  `TIPO_DOC` int(11) DEFAULT NULL,
  `TIPO_USUARIO` varchar(40) DEFAULT NULL,
  `CONTRASENA` varchar(200) DEFAULT NULL,
  `FECHA_CREACION` date DEFAULT NULL,
  `ESTADO` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_USUARIO`, `CEDULA`, `TIPO_DOC`, `TIPO_USUARIO`, `CONTRASENA`, `FECHA_CREACION`, `ESTADO`) VALUES
(1, 1144168383, 1, 'ADMIN', '123', '2018-05-18', 'A'),
(168, 10002841, 1, 'Usuario', '2agdgb5d', '2018-07-01', 'A'),
(169, 10006171, 1, 'Usuario', '272dd0dc', '2018-07-01', 'A'),
(170, 10006924, 1, 'Usuario', '1e3gg04f', '2018-07-01', 'A'),
(171, 1000870241, 1, 'Usuario', 'ddaa5dc9', '2018-07-01', 'A'),
(172, 1000930458, 1, 'Usuario', '28g0f3de', '2018-07-01', 'A'),
(173, 10012624, 1, 'Usuario', '24g30cb0', '2018-07-01', 'A'),
(174, 1001283419, 1, 'Usuario', '1g394f5d', '2018-07-01', 'A'),
(175, 10013708, 1, 'Usuario', '292g3179', '2018-07-01', 'A'),
(176, 10013715, 1, 'Usuario', 'fade380c', '2018-07-01', 'A'),
(177, 10014154, 1, 'Usuario', '313bg312', '2018-07-01', 'A'),
(178, 10014939, 1, 'Usuario', '22f4f5c0', '2018-07-01', 'A');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `acciones_pagina`
--
ALTER TABLE `acciones_pagina`
  ADD PRIMARY KEY (`ID_ACCION`),
  ADD KEY `FK_ACCIONES_PAGINA_PAGINAS` (`ID_PAGINA`);

--
-- Indices de la tabla `cargue_archivos`
--
ALTER TABLE `cargue_archivos`
  ADD PRIMARY KEY (`ID_CARGUE`),
  ADD KEY `FK_CARGUE_ARCHIVOS_AFILIADO` (`ID_CLIENTE`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID_CLIENTE`);

--
-- Indices de la tabla `cliente_usuario`
--
ALTER TABLE `cliente_usuario`
  ADD PRIMARY KEY (`ID_CLIENTE_USUARIO`),
  ADD KEY `FK_CLIENTE_USUARIO_AFILIADO` (`ID_CLIENTE`),
  ADD KEY `FK_CLIENTE_USUARIO_USUARIO` (`ID_USUARIO`);

--
-- Indices de la tabla `compromiso`
--
ALTER TABLE `compromiso`
  ADD PRIMARY KEY (`ID_COMPROMISO`),
  ADD KEY `FK_COMPROMISO_OBLIGACION` (`ID_OBLIGACION`);

--
-- Indices de la tabla `detalle_cargue`
--
ALTER TABLE `detalle_cargue`
  ADD PRIMARY KEY (`ID_CARGUE`,`NUMERO_TITULO_VALOR`,`CUOTA`,`CEDULA`);

--
-- Indices de la tabla `detalle_obligacion`
--
ALTER TABLE `detalle_obligacion`
  ADD PRIMARY KEY (`ID_DETALLE_OBLI`),
  ADD KEY `FK_DETALLE_OBLIGACION` (`ID_OBLIGACION`);

--
-- Indices de la tabla `estado_cargue`
--
ALTER TABLE `estado_cargue`
  ADD PRIMARY KEY (`ID_ESTADO_CARGUE`),
  ADD KEY `FK_ESTADO_CAE_PLALAS_EMAIL` (`ID_PLANTILLA`);

--
-- Indices de la tabla `estado_notificacion_cargue`
--
ALTER TABLE `estado_notificacion_cargue`
  ADD PRIMARY KEY (`ID_ESTADO_NOT_CARG`),
  ADD KEY `FK_ESTADO_NOTIF_CARGUE_ARCHIVOS` (`ID_CARGUE`),
  ADD KEY `FK_ESTADO_NO_CAR_ESTADO_CARGUE` (`ID_ESTADO_CARGUE`);

--
-- Indices de la tabla `estado_notificacion_usuario`
--
ALTER TABLE `estado_notificacion_usuario`
  ADD PRIMARY KEY (`ID_ESTADO_NOT_USU`),
  ADD KEY `FK_ESTADO_NOT_USUARIO_EST_USU` (`ID_ESTADO_USUARIO`),
  ADD KEY `FK_ESTADO_NOTIF_USU_CLIENTE_USU` (`ID_CLIENTE_USUARIO`);

--
-- Indices de la tabla `estado_usuario`
--
ALTER TABLE `estado_usuario`
  ADD PRIMARY KEY (`ID_ESTADO_USUARIO`),
  ADD KEY `FK_ESTADO_USUARIO_TILLAS_EMAIL` (`ID_PLANTILLA`);

--
-- Indices de la tabla `obligacion`
--
ALTER TABLE `obligacion`
  ADD PRIMARY KEY (`ID_OBLIGACION`),
  ADD KEY `FK_OBLIGACION_CLIENTE_USUARIO` (`ID_CLIENTE_USUARIO`);

--
-- Indices de la tabla `paginas`
--
ALTER TABLE `paginas`
  ADD PRIMARY KEY (`ID_PAGINA`);

--
-- Indices de la tabla `permisos_usuarios`
--
ALTER TABLE `permisos_usuarios`
  ADD PRIMARY KEY (`ID_PERMISO`),
  ADD KEY `FK_PER_USU_ACCI_PAG` (`ID_ACCION`),
  ADD KEY `FK_PERMISOS_USUARIOS_USUARIO` (`ID_USUARIO`);

--
-- Indices de la tabla `plantillas_email`
--
ALTER TABLE `plantillas_email`
  ADD PRIMARY KEY (`ID_PLANTILLA`);

--
-- Indices de la tabla `sesiones_activas`
--
ALTER TABLE `sesiones_activas`
  ADD PRIMARY KEY (`ID_SESION`),
  ADD KEY `FK_SESIONES_ACTIVAS_USUARIO` (`ID_USUARIO`);

--
-- Indices de la tabla `token`
--
ALTER TABLE `token`
  ADD PRIMARY KEY (`ID_TOKEN`),
  ADD KEY `FK_TOKEN_USUARIO` (`ID_USUARIO`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID_USUARIO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `acciones_pagina`
--
ALTER TABLE `acciones_pagina`
  MODIFY `ID_ACCION` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cargue_archivos`
--
ALTER TABLE `cargue_archivos`
  MODIFY `ID_CARGUE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cliente_usuario`
--
ALTER TABLE `cliente_usuario`
  MODIFY `ID_CLIENTE_USUARIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=119;

--
-- AUTO_INCREMENT de la tabla `compromiso`
--
ALTER TABLE `compromiso`
  MODIFY `ID_COMPROMISO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_obligacion`
--
ALTER TABLE `detalle_obligacion`
  MODIFY `ID_DETALLE_OBLI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `estado_cargue`
--
ALTER TABLE `estado_cargue`
  MODIFY `ID_ESTADO_CARGUE` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estado_notificacion_cargue`
--
ALTER TABLE `estado_notificacion_cargue`
  MODIFY `ID_ESTADO_NOT_CARG` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estado_notificacion_usuario`
--
ALTER TABLE `estado_notificacion_usuario`
  MODIFY `ID_ESTADO_NOT_USU` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estado_usuario`
--
ALTER TABLE `estado_usuario`
  MODIFY `ID_ESTADO_USUARIO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `obligacion`
--
ALTER TABLE `obligacion`
  MODIFY `ID_OBLIGACION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `paginas`
--
ALTER TABLE `paginas`
  MODIFY `ID_PAGINA` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `permisos_usuarios`
--
ALTER TABLE `permisos_usuarios`
  MODIFY `ID_PERMISO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `plantillas_email`
--
ALTER TABLE `plantillas_email`
  MODIFY `ID_PLANTILLA` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sesiones_activas`
--
ALTER TABLE `sesiones_activas`
  MODIFY `ID_SESION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT de la tabla `token`
--
ALTER TABLE `token`
  MODIFY `ID_TOKEN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=179;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `acciones_pagina`
--
ALTER TABLE `acciones_pagina`
  ADD CONSTRAINT `FK_ACCIONES_PAGINA_PAGINAS` FOREIGN KEY (`ID_PAGINA`) REFERENCES `paginas` (`ID_PAGINA`);

--
-- Filtros para la tabla `cargue_archivos`
--
ALTER TABLE `cargue_archivos`
  ADD CONSTRAINT `FK_CARGUE_ARCHIVOS_AFILIADO` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`);

--
-- Filtros para la tabla `cliente_usuario`
--
ALTER TABLE `cliente_usuario`
  ADD CONSTRAINT `FK_CLIENTE_USUARIO_AFILIADO` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`),
  ADD CONSTRAINT `FK_CLIENTE_USUARIO_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`);

--
-- Filtros para la tabla `compromiso`
--
ALTER TABLE `compromiso`
  ADD CONSTRAINT `FK_COMPROMISO_OBLIGACION` FOREIGN KEY (`ID_OBLIGACION`) REFERENCES `obligacion` (`ID_OBLIGACION`);

--
-- Filtros para la tabla `detalle_cargue`
--
ALTER TABLE `detalle_cargue`
  ADD CONSTRAINT `FK_DETALLE_CAR_CARGE_ARCH` FOREIGN KEY (`ID_CARGUE`) REFERENCES `cargue_archivos` (`ID_CARGUE`);

--
-- Filtros para la tabla `detalle_obligacion`
--
ALTER TABLE `detalle_obligacion`
  ADD CONSTRAINT `FK_DETALLE_OBLIGACION` FOREIGN KEY (`ID_OBLIGACION`) REFERENCES `obligacion` (`ID_OBLIGACION`);

--
-- Filtros para la tabla `estado_cargue`
--
ALTER TABLE `estado_cargue`
  ADD CONSTRAINT `FK_ESTADO_CAE_PLALAS_EMAIL` FOREIGN KEY (`ID_PLANTILLA`) REFERENCES `plantillas_email` (`ID_PLANTILLA`);

--
-- Filtros para la tabla `estado_notificacion_cargue`
--
ALTER TABLE `estado_notificacion_cargue`
  ADD CONSTRAINT `FK_ESTADO_NOTIF_CARGUE_ARCHIVOS` FOREIGN KEY (`ID_CARGUE`) REFERENCES `cargue_archivos` (`ID_CARGUE`),
  ADD CONSTRAINT `FK_ESTADO_NO_CAR_ESTADO_CARGUE` FOREIGN KEY (`ID_ESTADO_CARGUE`) REFERENCES `estado_cargue` (`ID_ESTADO_CARGUE`);

--
-- Filtros para la tabla `estado_notificacion_usuario`
--
ALTER TABLE `estado_notificacion_usuario`
  ADD CONSTRAINT `FK_ESTADO_NOTIF_USU_CLIENTE_USU` FOREIGN KEY (`ID_CLIENTE_USUARIO`) REFERENCES `cliente_usuario` (`ID_CLIENTE_USUARIO`),
  ADD CONSTRAINT `FK_ESTADO_NOT_USUARIO_EST_USU` FOREIGN KEY (`ID_ESTADO_USUARIO`) REFERENCES `estado_usuario` (`ID_ESTADO_USUARIO`);

--
-- Filtros para la tabla `estado_usuario`
--
ALTER TABLE `estado_usuario`
  ADD CONSTRAINT `FK_ESTADO_USUARIO_TILLAS_EMAIL` FOREIGN KEY (`ID_PLANTILLA`) REFERENCES `plantillas_email` (`ID_PLANTILLA`);

--
-- Filtros para la tabla `obligacion`
--
ALTER TABLE `obligacion`
  ADD CONSTRAINT `FK_OBLIGACION_CLIENTE_USUARIO` FOREIGN KEY (`ID_CLIENTE_USUARIO`) REFERENCES `cliente_usuario` (`ID_CLIENTE_USUARIO`);

--
-- Filtros para la tabla `permisos_usuarios`
--
ALTER TABLE `permisos_usuarios`
  ADD CONSTRAINT `FK_PERMISOS_USUARIOS_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`),
  ADD CONSTRAINT `FK_PER_USU_ACCI_PAG` FOREIGN KEY (`ID_ACCION`) REFERENCES `acciones_pagina` (`ID_ACCION`);

--
-- Filtros para la tabla `sesiones_activas`
--
ALTER TABLE `sesiones_activas`
  ADD CONSTRAINT `FK_SESIONES_ACTIVAS_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`);

--
-- Filtros para la tabla `token`
--
ALTER TABLE `token`
  ADD CONSTRAINT `FK_TOKEN_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
