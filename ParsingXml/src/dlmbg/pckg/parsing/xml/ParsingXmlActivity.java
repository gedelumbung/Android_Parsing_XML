package dlmbg.pckg.parsing.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ParsingXmlActivity extends Activity {

	static final String URL = "http://10.0.2.2/json-parsing/artikel-xml.php";
	static final String AR_ITEM = "item";
	static final String AR_JUDUL = "judul";
	static final String AR_WAKTU = "waktu";
	static final String AR_ISI = "isi";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		 
		XMLParser parser = new XMLParser();
		String xml = parser.baca_xml_url(URL);
		Document doc = parser.ambil_elemen_dom(xml);
		 
		NodeList nd = doc.getElementsByTagName(AR_ITEM);
		
		String isi = "";
		TextView judul = (TextView) findViewById(R.id.isi);

		for (int i = 0; i < nd.getLength(); i++) {
			Element e = (Element) nd.item(i);
		    isi += parser.ambil_nilai(e, AR_JUDUL)+"\n"
		    		+parser.ambil_nilai(e, AR_WAKTU)+"\n"
		    		+parser.ambil_nilai(e, AR_ISI).substring(0, 100)+"...\n\n\n";
		}

	    judul.setText(isi);

	}
}