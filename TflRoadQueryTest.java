package com.epflores;

import junit.framework.TestCase;

/**
 * @author Eugene Paul Flores
 *
 */
public class TflRoadQueryTest extends TestCase {

    public void testMain() {
    	validRoadNameWithUppercaseA();
    	validRoadNameWithLowercaseA();
    	validRoadNameNotRecognised();
    	invalidRoadNameWithC(); 
    }

	public final void validRoadNameWithUppercaseA() {
        String[] results = AbstractMainTests.executeMain(TflRoadQuery.class, new String[]{"A2"});
        for (int i = 0; i < results.length; i++) {
			if(results[i].contains("\"Road Status:\"")){
				assertTrue(true);
			}
		}
	}
	
	public final void validRoadNameWithLowercaseA() {
        String[] results = AbstractMainTests.executeMain(TflRoadQuery.class, new String[]{"a2"});
        for (int i = 0; i < results.length; i++) {
			if(results[i].contains("\"Road Status:\"")){
				assertTrue(true);
			}
		}
	}
	
	public final void validRoadNameNotRecognised() {
        String[] results = AbstractMainTests.executeMain(TflRoadQuery.class, new String[]{"a233"});
        for (int i = 0; i < results.length; i++) {
			if(results[i].contains("not recognised:")){
				assertTrue(true);
			}
		}
	}
	
	public final void invalidRoadNameWithC() {
        String[] results = AbstractMainTests.executeMain(TflRoadQuery.class, new String[]{"C2"});
        for (int i = 0; i < results.length; i++) {
			if(results[i].contains("not valid:")){
				assertTrue(true);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
