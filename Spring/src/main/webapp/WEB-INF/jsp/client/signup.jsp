<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">

<!-- Title Page-->
<title>Inscription</title>

<!-- Icons font CSS-->
<link href="/vendor/mdi-font/css/material-design-iconic-font.min.css"
rel="stylesheet" media="all">
<link href="/vendor/font-awesome-4.7/css/font-awesome.min.css"
rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
rel="stylesheet">

<!-- Vendor CSS-->
<link href="/vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="/vendor/datepicker/daterangepicker.css" rel="stylesheet"
media="all">

<!-- Main CSS-->
<link href="/css/main.css" rel="stylesheet" media="all">
<link href="/css/header.css" rel="stylesheet" media="all">

</head>

<body>
 <div class="topnav">
  <a class="active" href="#home">Home</a>
  <a href="#about">About</a>
  <a href="#contact">Contact</a>
  <div class="row">
					<div class="col-sm-12">
						<div class="logo">
							<a href="index.html"> WIE<span>BATOUTA</span>
							</a>
						</div>
						<!-- /.logo-->
					</div>
					</div>
					
</div> 
<div class="page-wrapper bg-blue p-t-180 p-b-100 font-robo">
<div class="wrapper wrapper--w960">
<div class="card card-2">
<div class="card-heading"></div>
<div class="card-body">
<h2 class="title">Inscription en ligne</h2>
<form action="InscriptionEnLigne.php" method="POST" enctype="multipart/form-data">
<!--       <div class="input-group">
                           <input class="input--style-2" type="text" placeholder="Nom" name="name">
                       </div>

                       <div class="input-group">
                           <input class="input--style-2" type="text" placeholder="Name" name="name">
                       </div>  -->


<div class="row row-space">
<div class="col-2">
<div class="input-group">
<input class="input--style-2" type="text" placeholder="Nom"
name="NomFr">

</div>
</div>
<div class="col-2">
<div class="input-group">
<input class="input--style-2" type="text" placeholder="Prenom"
name="PrenomFr">
</div>
</div>
</div>



<!-- class="input--style-2 js-datepicker" -->
<div class="row row-space">
<div class="col-2">
<div class="input-group">
<input type="date"    placeholder="Date de naissance" name="dateN">

</div>
</div>
<div class="col-2">
<div class="input-group">
<div class="rs-select2 js-select-simple select--no-search">
<select name="sexe">
<option disabled="disabled" selected="selected">Sexe</option>
<option>M</option>
<option>F</option>
</select>
<div class="select-dropdown"></div>
</div>
</div>
</div>
</div>
<div class="input-group">
<div class="rs-select2 js-select-simple select--no-search">
<select name="lieuN_fr">
<option disabled="disabled" selected="selected">Lieu
de naissance</option>

</select>
<div class="select-dropdown"></div>
</div>
</div>


<div class="input-group">
<div class="rs-select2 js-select-simple select--no-search">

<div class="select-dropdown"></div>
</div>
</div>
<div class="input-group">
<div class="rs-select2 js-select-simple select--no-search">
<select name="nationalite">
<option disabled="disabled" selected="selected">
Nationnalité</option>
<option value="Afghan   ">Afghan</option>
<option value="Albanais">Albanais</option>
<option value="Algérien   ">Algérien</option>
<option value="Allemand">Allemand</option>
<option value="Américain">Américain</option>
<option value="Angolais   ">Angolais</option>
<option value="Argentin   ">Argentin</option>
<option value="Arménien   ">Arménien</option>
<option value="Arubais    ">Arubais</option>
<option value="Australien">Australien</option>
<option value="Autrichien ">Autrichien</option>
<option value="Azerbaïdjanais ">Azerbaïdjanais</option>
<option value="Bahaméen   ">Bahaméen</option>
<option value="Bangladais ">Bangladais</option>
<option value="Belge">Belge</option>
<option value="Benin">Benin</option>
<option value="Biélorusse ">Biélorusse</option>
<option value="Birmain    ">Birmain</option>
<option value="Bolivien   ">Bolivien</option>
<option value="Bosniaque">Bosniaque</option>
<option value="Botswanais ">Botswanais</option>
<option value="Bouthan    ">Bouthan</option>
<option value="Brésilien  ">Brésilien</option>
<option value="Britannique    ">Britannique</option>
<option value="Bulgare">Bulgare</option>
<option value="Burkinabè  ">Burkinabè</option>
<option value="Cambodgien ">Cambodgien</option>
<option value="Camerounais    ">Camerounais</option>
<option value="Canadien   ">Canadien</option>
<option value="Chilien">Chilien</option>
<option value="Chinois    ">Chinois</option>
<option value="Chypriote">Chypriote</option>
<option value="Colombien  ">Colombien</option>
<option value="Congolais  ">Congolais</option>
<option value="Costaricain">Costaricain</option>
<option value="Croate ">Croate</option>
<option value="Cubain ">Cubain</option>
<option value="Danois ">Danois</option>
<option value="Dominicain ">Dominicain</option>
<option value="Ecossais">Ecossais</option>
<option value="Egyptien   ">Egyptien</option>
<option value="Emirati    ">Emirati</option>
<option value="Equatorien ">Equatorien</option>
<option value="Espagnol   ">Espagnol</option>
<option value="Estonien">Estonien</option>
<option value="Ethiopien  ">Ethiopien</option>
<option value="Européen   ">Européen</option>
<option value="Finlandais ">Finlandais</option>
<option value="Français   ">Français</option>
<option value="Gabonais">Gabonais</option>
<option value="Georgien   ">Georgien</option>
<option value="Ghanéen    ">Ghanéen</option>
<option value="Grec   ">Grec</option>
<option value="Guatemala  ">Guatemala</option>
<option value="Guinéen">Guinéen</option>
<option value="Haïtien    ">Haïtien</option>
<option value="Hollandais ">Hollandais</option>
<option value="Hong-Kong  ">Hong-Kong</option>
<option value="Hongrois   ">Hongrois</option>
<option value="Indien">Indien</option>
<option value="Indonésien ">Indonésien</option>
<option value="Irakien    ">Irakien</option>
<option value="Iranien    ">Iranien</option>
<option value="Irlandais  ">Irlandais</option>
<option value="Islandais">Islandais</option>
<option value="Israélien  ">Israélien</option>
<option value="Italien    ">Italien</option>
<option value="Ivoirien   ">Ivoirien</option>
<option value="Jamaïcain">Jamaïcain</option>
<option value="Japonais">Japonais</option>
<option value="Jordanien">Jordanien</option>
<option value="Kazakh ">Kazakh</option>
<option value="Kenyan ">Kenyan</option>
<option value="Kirghiz    ">Kirghiz</option>
<option value="Kosovar">Kosovar</option>
<option value="Koweïtien  ">Koweïtien</option>
<option value="Kurde  ">Kurde</option>
<option value="Laotien    ">Laotien</option>
<option value="Letton">Letton</option>
<option value="Libanais">Libanais</option>
<option value="Libyen ">Libyen</option>
<option value="Liechtenstein  ">Liechtenstein</option>
<option value="Lituanien  ">Lituanien</option>
<option value="Luxembourgeois ">Luxembourgeois</option>
<option value="Macédonien">Macédonien</option>
<option value="Madagascar ">Madagascar</option>
<option value="Malaisien  ">Malaisien</option>
<option value="Malien">Malien</option>
<option value="Maltais    ">Maltais</option>
<option value="Marocain">Marocain</option>
<option value="Mauritanien    ">Mauritanien</option>
<option value="Mauritien  ">Mauritien</option>
<option value="Mexicain   ">Mexicain</option>
<option value="Monégasque ">Monégasque</option>
<option value="Mongol">Mongol</option>
<option value="Mozambique ">Mozambique</option>
<option value="Namibien   ">Namibien</option>
<option value="Néo-Zélandais  ">Néo-Zélandais</option>
<option value="Népalais   ">Népalais</option>
<option value="Nigérien">Nigérien</option>
<option value="Nord Coréen    ">Nord Coréen</option>
<option value="Norvégien  ">Norvégien</option>
<option value="Pakistanais    ">Pakistanais</option>
<option value="Palestinien    ">Palestinien</option>
<option value="Panaméen">Panaméen</option>
<option value="Paraguayen ">Paraguayen</option>
<option value="Péruvien   ">Péruvien</option>
<option value="Philippiens    ">Philippiens</option>
<option value="Polonais">Polonais</option>
<option value="Portoricain">Portoricain</option>
<option value=""></option>
<option value="Portugais  ">Portugais</option>
<option value="Qatar  ">Qatar</option>
<option value="Roumain">Roumain</option>
<option value="Russe  ">Russe</option>
<option value="Rwandais">Rwandais</option>
<option value="Saoudien   ">Saoudien</option>
<option value="Sénégalais ">Sénégalais</option>
<option value="Serbe  ">Serbe</option>
<option value="Serbo-Croate   ">Serbo-Croate</option>
<option value="Singapour">Singapour</option>
<option value="Slovaque   ">Slovaque</option>
<option value="Soudanais  ">Soudanais</option>
<option value="Soviétique ">Soviétique</option>
<option value="Sri-Lankais    ">Sri-Lankais</option>
<option value="Sud-Africain">Sud-Africain</option>
<option value="Sud-Coréen ">Sud-Coréen</option>
<option value="Suédois    ">Suédois</option>
<option value="Suisse ">Suisse</option>
<option value="Syrien ">Syrien</option>
<option value="Tadjik">Tadjik</option>
<option value="Taïwanais  ">Taïwanais</option>
<option value="Tanzanien  ">Tanzanien</option>
<option value="Tchadien   ">Tchadien</option>
<option value="Tchèque    ">Tchèque</option>
<option value="Thaïlandais">Thaïlandais</option>
<option value="Tunisien   ">Tunisien</option>
<option value="Turc   ">Turc</option>
<option value="Ukranien   ">Ukranien</option>
<option value="Uruguayen  ">Uruguayen</option>
<option value="Vénézuélien">Vénézuélien</option>
<option value="Vietnamien ">Vietnamien</option>
<option value="Yéménite   ">Yéménite</option>
<option value="Yougoslave ">Yougoslave</option>
<option value="Zimbabwéen">Zimbabwéen</option>

</select>
<div class="select-dropdown"></div>
</div>
</div>









<div class="row row-space">
<div class="col-2">
<div class="input-group">
<div class="rs-select2 js-select-simple select--no-search">
<select name="province">
<option disabled="disabled" selected="selected">Province</option>
<option value="Province de Tétouan">Province de
Tétouan</option>
<option value="Province de Fahs-Anjra">Province de
Fahs-Anjra</option>
<option value="Province de Larache">Province de
Larache</option>
<option value="Province d&#x27;Al Hoceïma">Province
d&#x27;Al Hoceïma</option>
<option value="Province de Chefchaouen">Province de
Chefchaouen</option>
<option value="Province d&#x27;Ouezzane">Province
d&#x27;Ouezzane</option>
<option value="Province de Nador">Province de Nador
</option>
<option value="Province de Driouch">Province de
Driouch</option>
<option value="Province de Jerada">Province de
Jerada</option>
<option value="Province de Berkane">Province de
Berkane</option>
<option value="Province de Taourirt">Province de
Taourirt</option>
<option value="Province de Guercif">Province de
Guercif</option>
<option value="Province de Figuig">Province de
Figuig</option>
<option value="Province d’El Hajeb">Province d’El
Hajeb</option>
<option value="Province d’Ifrane">Province d’Ifrane
</option>
<option value="Province de Moulay Yaâcoub">Province
de Moulay Yaâcoub</option>
<option value="Province de Séfrou">Province de
Séfrou</option>
<option value="Province de Boulemane">Province de
Boulemane</option>
<option value="Province de Taounate">Province de
Taounate</option>
<option value="Province de Taza">Province de Taza</option>
<option value="Province de Kénitra">Province de
Kénitra</option>
<option value="Province de Khémisset">Province de
Khémisset</option>
<option value="Province de Sidi Kacem">Province de
Sidi Kacem</option>
<option value="Province de Sidi Slimane">Province de
Sidi Slimane</option>
<option value="Province de Béni-Mellal">Province de
Béni-Mellal</option>
<option value="Province d&#x27;Azilal">Province
d&#x27;Azilal</option>
<option value="Province de Fquih Ben Salah">
Province de Fquih Ben Salah</option>
<option value="Province de Khénifra">Province de
Khénifra</option>
<option value="Province de Khouribga">Province de
Khouribga</option>
<option value="Province d&#x27;El Jadida">Province
d&#x27;El Jadida</option>
<option value="Province de Nouaceur">Province de
Nouaceur</option>
<option value="Province de Médiouna">Province de
Médiouna</option>
<option value="Province de Benslimane">Province de
Benslimane</option>
<option value="Province de Berrechid">Province de
Berrechid</option>
<option value="Province de Settat">Province de
Settat</option>
<option value="Province de Sidi Bennour">Province de
Sidi Bennour</option>
<option value="Province de Chichaoua">Province de
Chichaoua</option>
<option value="Province d&#x27;Al Haouz">Province
d&#x27;Al Haouz</option>
<option value="Province d&#x27;El Kelaâ des Sraghna">
Province d&#x27;El Kelaâ des Sraghna</option>
<option value="Province d&#x27;Essaouira">Province
d&#x27;Essaouira</option>
<option value="Province de Rehamna">Province de
Rehamna</option>
<option value="Province de Safi">Province de Safi</option>
<option value="Province de Youssoufia">Province de
Youssoufia</option>
<option value="Province d&#x27;Errachidia">Province
d&#x27;Errachidia</option>
<option value="Province de Ouarzazate">Province de
Ouarzazate</option>
<option value="Province de Midelt">Province de
Midelt</option>
<option value="Province de Tinghir">Province de
Tinghir</option>
<option value="Province de Zagora">Province de
Zagora</option>
<option value="Province de Chtouka-Aït Baha">
Province de Chtouka-Aït Baha</option>
<option value="Province de Taroudant">Province de
Taroudant</option>
<option value="Province de Tiznit">Province de
Tiznit</option>
<option value="Province de Tata">Province de Tata</option>
<option value="Province de Guelmim">Province de
Guelmim</option>
<option value="Province d&#x27;Assa-Zag">Province
d&#x27;Assa-Zag</option>
<option value="Province de Tan-Tan">Province de
Tan-Tan</option>
<option value="Province de Sidi Ifni">Province de
Sidi Ifni</option>
<option value="Province de Laâyoune">Province de
Laâyoune</option>
<option value="Province de Boujdour">Province de
Boujdour</option>
<option value="Province de Tarfaya">Province de
Tarfaya</option>
<option value="Province d&#x27;Es-Semara">Province
d&#x27;Es-Semara</option>
<option value="Province d&#x27;Oued Ed Dahab">
Province d&#x27;Oued Ed Dahab</option>
<option value="Province d&#x27;Aousserd">Province
d&#x27;Aousserd</option>
<option value="Autres">Autres</option>
</select>
<div class="select-dropdown"></div>
</div>

</div>
</div>

<div class="col-2">
<div class="input-group">
<div class="rs-select2 js-select-simple select--no-search">
<select name="region">
<option disabled="disabled" selected="selected">Region</option>
<option value="Région de Tanger-Tétouan-Al Hoceïma">
Région de Tanger-Tétouan-Al Hoceïma</option>
<option value="Région de l&#x27;Oriental">Région de
l&#x27;Oriental</option>
<option value="Région de Fès-Meknès">Région de
Fès-Meknès</option>
<option value="Région de Rabat-Salé-Kénitra">Région
de Rabat-Salé-Kénitra</option>
<option value="Région de Béni Mellal-Khénifra">
Région de Béni Mellal-Khénifra</option>
<option value="Région de Casablanca-Settat">Région
de Casablanca-Settat</option>
<option value="Région de Marrakech-Safi">Région de
Marrakech-Safi</option>
<option value="Région de Drâa-Tafilalet">Région de
Drâa-Tafilalet</option>
<option value="Région de Souss-Massa">Région de
Souss-Massa</option>
<option value="Région de Guelmim-Oued Noun">Région
de Guelmim-Oued Noun</option>
<option value="Région de Laâyoune-Sakia El Hamra">
Région de Laâyoune-Sakia El Hamra</option>
<option value="Région de Dakhla-Oued Ed Dahab">
Région de Dakhla-Oued Ed Dahab</option>
<option value="Autres">Autres</option>
</select>
<div class="select-dropdown"></div>
</div>
</div>
</div>


</div>






























<div class="row row-space">
<div class="col-2">
<div class="input-group">
<input class="input--style-2" type="text" placeholder="cin"
name="cin">

</div>
</div>
<div class="col-2">
<div class="input-group">
<input class="input--style-2" type="text"
placeholder="Code massar" name="massarEtud">
</div>
</div>
</div>


<div class="row row-space">
<div class="col-2">
<div class="input-group">

<input type="email" id="email" name="email" placeholder="Enter your Email">
</div>
</div>
</div>



<div class="input-group">
<div class="rs-select2 js-select-simple select--no-search">
<select name="sBac">
<option disabled="disabled" selected="selected">Serie
Bac</option>
<option value="Sciences de la Vie et de la Terre">
Sciences de la Vie et de la Terre</option>
<option value="Sciences Physiques et Chimiques">
Sciences Physiques et Chimiques</option>
<option value="Sciences Maths A">Sciences Maths A</option>
<option value="Sciences Maths B">Sciences Maths B</option>
<option value="Sciences agronomiques">Sciences
agronomiques</option>
<option value="Sciences et Technologies Electriques">
Sciences et Technologies Electriques</option>
<option value="Sciences et Technologies Mécaniques">
Sciences et Technologies Mécaniques</option>
</select>
<div class="select-dropdown"></div>
</div>
</div>







<div class="input-group">
<div class="rs-select2 js-select-simple select--no-search">
<select name="mt">
<option disabled="disabled" selected="selected">
Mention du bac</option>
<option value="Très bien ">Très bien</option>
<option value="bien">bien</option>
<option value="assez bien">assez bien</option>
<option value="passable">passable</option>


</select>
<div class="select-dropdown"></div>
</div>
</div>



<div class="row row-space">
<div class="col-2">
<div class="input-group">
<input class="input--style-2" type="text"
placeholder="Lycee du Bac" name="lycee">

</div>
</div>

<div class="col-2">
<div class="input-group">
<div class="rs-select2 js-select-simple select--no-search">
<select name="villeBac">
<option disabled="disabled" selected="selected">Ville
du bac</option>
<option value=" AL HAJEB">AL HAJEB</option>
<option value=" AGADIR ">AGADIR</option>
<option value="AL HOCEIMA ">AL HOCEIMA</option>
<option value="ASSA ">ASSA</option>
<option value="ZAG ">ZAG</option>
<option value="AZILAL ">AZILAL</option>
<option value="BENI MELLAL">BENI MELLAL</option>
<option value=" BENSLIMANE ">BENSLIMANE</option>
<option value="BOUJDOUR">BOUJDOUR</option>
<option value=" BOULEMANE ">BOULEMANE</option>
<option value="BERRECHID ">BERRECHID</option>
<option value="CASABLANCA ">CASABLANCA</option>
<option value="CHEFCHAOUEN ">CHEFCHAOUEN</option>
<option value="CHTOUKA ">CHTOUKA</option>
<option value="AIT BAHA ">AIT BAHA</option>
<option value="CHICHAOUA">CHICHAOUA</option>
<option value=" EL JADIDA">EL JADIDA</option>
<option value=" EL KELAA DES SRAGHNAS">EL KELAA DES
SRAGHNAS</option>
<option value=" ERRACHIDIA ">ERRACHIDIA</option>
<option value="ESSAOUIRA">ESSAOUIRA</option>
<option value=" ES SEMARA">ES SEMARA</option>
<option value=" FES ">FES</option>
<option value="FIGUIG">FIGUIG</option>
<option value=" GUELMIM">GUELMIM</option>
<option value=" IFRANE">IFRANE</option>
<option value=" KENITRA">KENITRA</option>
<option value=" KHEMISSET">KHEMISSET</option>
<option value=" KHENIFRA ">KHENIFRA</option>
<option value="KHOURIBGA ">KHOURIBGA</option>
<option value="LAAYOUNE">LAAYOUNE</option>
<option value=" LARACHE ">LARACHE</option>
<option value="MOHAMMEDIA ">MOHAMMEDIA</option>
<option value="MARRAKECH ">MARRAKECH</option>
<option value="MEKNES ">MEKNES</option>
<option value="NADOR">NADOR</option>
<option value=" OUARZAZATE">OUARZAZATE</option>
<option value=" OUJDA ">OUJDA</option>
<option value="OUED EDDAHAB ">OUED EDDAHAB</option>
<option value="RABAT ">RABAT</option>
<option value="SALE ">SALE</option>
<option value="SKHIRAT">SKHIRAT</option>
<option value=" TEMARA ">TEMARA</option>
<option value="SEFROU">SEFROU</option>
<option value=" SAFI">SAFI</option>
<option value=" SETTAT">SETTAT</option>
<option value=" SIDI KACEM ">SIDI KACEM</option>
<option value="TANGER ">TANGER</option>
<option value="TAN TAN">TAN TAN</option>
<option value=" TAOUNAT ">TAOUNAT</option>
<option value="TAROUDANNT">TAROUDANNT</option>
<option value=" TATA">TATA</option>
<option value=" TAZA">TAZA</option>
<option value=" TETOUAN ">TETOUAN</option>
<option value="TIZNIT">TIZNIT</option>
</select>
<div class="select-dropdown"></div>
</div>
</div>
</div>


</div>






<div class="input-group">
<div class="rs-select2 js-select-simple select--no-search">
<select name="acad">
<option disabled="disabled" selected="selected">
Academie</option>
<option value="Dakhla-Oued Ed-Dahab">Dakhla-Oued
Ed-Dahab</option>
<option value="Laâyoune-Sakia El Hamra">
Laâyoune-Sakia El Hamra</option>
<option value="Guelmim-Oued Noun">Guelmim-Oued Noun</option>
<option value="Souss-Massa">Souss-Massa</option>
<option value="Marrakech-Safi">Marrakech-Safi</option>
<option value=" L’oriental">L’oriental</option>
<option value="Casablanca-Settat">Casablanca-Settat</option>
<option value="Rabat-Salé-Kénitra">Rabat-Salé-Kénitra
</option>
<option value=" Béni Mellal-Khénifra">Béni
Mellal-Khénifra</option>
<option value="Drâa Tafilalt">Drâa Tafilalt</option>
<option value="Fès-Meknès">Fès-Meknès</option>
<option value="Tanger - Tetouan - Alhouceima">Tanger -
Tetouan - Alhouceima</option>


</select>
<div class="select-dropdown"></div>
</div>
</div>






<div class="input-group">
<div class="rs-select2 js-select-simple select--no-search">
<select name="an_Bac">
<option disabled="disabled" selected="selected">Année
d'obtention du bac</option>
<option value="1980">1980</option>
<option value="1981">1981</option>
<option value="1982">1982</option>
<option value="1983">1983</option>
<option value="1984">1984</option>
<option value="1985">1985</option>
<option value="1986">1986</option>
<option value="1987">1987</option>
<option value="1988">1988</option>
<option value="1989">1989</option>
<option value="1990">1990</option>
<option value="1991">1991</option>
<option value="1992">1992</option>
<option value="1993">1993</option>
<option value="1994">1994</option>
<option value="1995">1995</option>
<option value="1996">1996</option>
<option value="1997">1997</option>
<option value="1998">1998</option>
<option value="1999">1999</option>
<option value="2000">2000</option>
<option value="2001">2001</option>
<option value="2002">2002</option>
<option value="2003">2003</option>
<option value="2004">2004</option>
<option value="2005">2005</option>
<option value="2006">2006</option>
<option value="2007">2007</option>
<option value="2008">2008</option>
<option value="2009">2009</option>
<option value="2010">2010</option>
<option value="2011">2011</option>
<option value="2012">2012</option>
<option value="2013">2013</option>
<option value="2014">2014</option>
<option value="2015">2015</option>
<option value="2016">2016</option>
<option value="2017">2017</option>
<option value="2018">2018</option>
<option value="2019">2019</option>
<option value="2020">2020</option>


</select>
<div class="select-dropdown"></div>
</div>
</div>























<div class="row row-space">
<div class="col-2">
<div class="input-group">
<div class="rs-select2 js-select-simple select--no-search">
<select name="etatPhy">
<option disabled="disabled" selected="selected">Etat
physique</option>
<option value="Province de Tétouan">Sain</option>
<option value="Province de Fahs-Anjra">Déplacement
limité</option>
<option value="Province de Larache">Sain</option>

<option value="Autres">Autres</option>
</select>
<div class="select-dropdown"></div>
</div>

</div>
</div>

<div class="col-2">
<div class="input-group">
<div class="rs-select2 js-select-simple select--no-search">
<select name="GroupSocio">
<option disabled="disabled" selected="selected">Groupe
socioprofessionnel</option>
<option value="Agriculteurs exploitants">
Agriculteurs exploitants</option>
<option value="Artisans, commerçants et chefs d’entreprise">
Artisans, commerçants et chefs d’entreprise</option>
<option
value="Cadres et professions intellectuelles supérieures">
Cadres et professions intellectuelles supérieures</option>
<option value="Professions intermédiaires">
Professions intermédiaires</option>
<option value="Employés">Employés</option>
<option value="Ouvriers">Ouvriers</option>
<option value="Retraités">Retraités</option>
<option
value="Autres personnes sans activité professionnelle">
Autres personnes sans activité professionnelle</option>
<option value="Autres">Autres</option>
</select>
<div class="select-dropdown"></div>
</div>
</div>
</div>


</div>



<div class="input-group">

<p class="input--style-2">Photo</p>

<div class="rs-select2 js-select-simple select--no-search">

<input type="file" id="avatar" name="photo"
accept=".png, .jpg, .jpeg" placeholder="photo">
</div>
</div>




<div class="p-t-30">
<button class="login100-form-btn" type="submit">S'inscrire</button>
</div>
</form>
</div>
</div>
</div>
</div>

<!-- Jquery JS-->
<script src="/vendor/jquery/jquery.min.js"></script>
<!-- Vendor JS-->
<script src="/vendor/select2/select2.min.js"></script>
<script src="/vendor/datepicker/moment.min.js"></script>
<script src="/vendor/datepicker/daterangepicker.js"></script>
<!-- Main JS-->
<script src="/js/global.js"></script>

</body>

</html>
<!-- end document-->

