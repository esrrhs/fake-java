package fakescript;

import java.util.HashMap;

class funcmap
{
	private fake m_f;
	private HashMap<variant, funcunion> m_funcmap = new HashMap<variant, funcunion>();
	
	public funcmap(fake f)
	{
		m_f = f;
	}
	
	public String dump()
	{
		return "";
	}
	
	public int size()
	{
		return 0;
	}
	
	public void add_func(variant name, func_binary fb)
	{
		funcunion f = add_func_union(name);
		f.m_fb = fb;
		f.m_havefb = true;
	}
	
	public void add_func(variant name, fkfunctor ff)
	{
		funcunion f = add_func_union(name);
		f.m_ff = ff;
		f.m_haveff = true;
	}
	
	public void add_func(variant name, bifunc bif)
	{
		funcunion f = add_func_union(name);
		f.m_bif = bif;
		f.m_havebif = true;
	}
	
	public funcunion get_func(variant name)
	{
		return m_funcmap.get(name);
	}
	
	public HashMap<variant, funcunion> get_funcmap()
	{
		return m_funcmap;
	}
	
	private funcunion add_func_union(variant name)
	{
		funcunion p = m_funcmap.get(name);
		if (p != null)
		{
			return p;
		}
		
		funcunion tmp = new funcunion();
		m_funcmap.put(name, tmp);
		return tmp;
	}
	
}
