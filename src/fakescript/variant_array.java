package fakescript;

import java.util.ArrayList;

class variant_array
{
	public ArrayList<variant> m_va = new ArrayList<variant>();
	public boolean m_isconst;
	public int m_recur;

	public variant con_array_get(variant kv) throws Exception
	{
		int i = (int) kv.get_real();

		if (i >= m_va.size())
		{
			for (int j = 0; j < i - m_va.size() + 1; j++)
			{
				m_va.add(null);
			}
		}

		variant vv = m_va.get(i);
		if (vv == null)
		{
			vv = new variant();
			m_va.set(i, vv);
		}
		return vv;
	}
}
