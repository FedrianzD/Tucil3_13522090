# Tucil3_13522090 Word Ladder
> Pemecahan persoalan game Word Ladder dengan menggunakan algoritma Uniform Cost Search, Greedy Best First Search, dan A* menggunakan bahasa Java.

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Setup](#setup)
* [Usage](#usage)
* [Project Status](#project-status)
* [Room for Improvement](#room-for-improvement)
<!-- * [License](#license) -->


## General Information
- Word ladder adalah salah satu permainan kata yang ditemukan oleh Lewis Carroll, seorang penulis dan matematikawan, pada tahun 1877. Pada permainan ini, pemain diberikan dua kata yang disebut sebagai start word dan end word. Untuk memenangkan permainan, pemain harus menemukan rantai kata yang dapat menghubungkan antara start word dan end word. Banyaknya huruf pada start word dan end word selalu sama. Tiap kata yang berdekatan dalam rantai kata tersebut hanya boleh berbeda satu huruf saja. Pada permainan ini, diharapkan solusi dengan banyaknya kata pada rantai kata seminimal mungkin.
- Project ini akan memberikan solusi untuk permainan Word Ladder dengan menggunakan algoritma Uniform Cost Search, Greedy Best First Search, dan A*.


## Technologies Used
- Java version "20.0.1" 2023-04-18 
- Visual Studio Code 1.89.0
- IntelliJ IDEA 2023.1.2 (Community Edition)


## Features
Fitur yang tersedia
- Algoritma Uniform Cost Search
- Algoritma Greedy Best First Search
- Algoritma A*
- GUI 


## Requirement
- Install Java version 20 or higher from https://www.oracle.com/id/java/technologies/downloads/


## Usage
- Clone repository `git clone https://github.com/FedrianzD/Tucil3_13522090.git`.
- Masuk ke dalam folder `Tucil3_13522090` dan buka terminal pada folder tersebut.
- Jika ingin menggunakan `dict.txt` sendiri, masukkan file txt ke dalam `src/sourceDict/` lalu jalankan `java -jar Divider.jar` pada terminal.
- Jalankan `java -jar CLI.jar` pada terminal untuk menjalankan program.
- Jalankan `java -jar GUI.jar` pada terminal untuk menjalankan program dengan GUI.
- Masukkan start word dan end word lalu jalankan, hasil akan muncul setelah beberapa saat.
- Jika tidak bisa menggunakan jar, pindah ke folder `cd bin/production/Tucil3_13522090`
- Lalu masukkan `java src/Main` untuk program berbasis CLI
- atau `java src/GUI` untuk program dengan GUI
- Jika ingin menggunakan `dict.txt` sendiri, masukkan file txt ke dalam `bin/production/Tucil3_13522090/src/sourceDict/`
- lalu jalankan `java src/DictReader` untuk membagi file kamus menjadi beberapa bagian berdasarkan jumlah huruf


## Project Status
Project is: _complete_


## Room for Improvement

Room for improvement:
- Improve GUI 
- Improve code to be faster


