<?php
include("koneksi.php");
$q = mysql_query('
SELECT * FROM tbl_content
');
$v = '<?xml version="1.0" encoding="UTF-8"?><menu>';
while($r=mysql_fetch_array($q))
{
	$ob = array('"','<br>','</br>');
	$v .= '<item>';
	$v .= '<id>'.str_replace($ob,' ',strip_tags($r["id_content"])).'</id>';
	$v .= '<judul>'.str_replace($ob,' ',strip_tags($r["judul"])).'</judul>';
	$v .= '<waktu>'.str_replace($ob,' ',strip_tags($r["waktu"])).' - '.str_replace($ob,' ',strip_tags($r["tanggal"])).'</waktu>';
	$v .= '<isi>'.str_replace($ob,' ',strip_tags($r["content"])).'</isi>';
	$v .= '</item>';
}
$v .= '</menu>';
echo $v;
?>