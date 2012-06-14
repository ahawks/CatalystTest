package catalyst.test.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
//	Format dfOut = new SimpleDateFormat("MM/dd/yyyy");
	Format df= new SimpleDateFormat("yyyy-MM-dd");
	

	@Override
	public Date unmarshal(String v) throws Exception {
		return (Date) df.parseObject(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		return df.format(v);
	}

}
