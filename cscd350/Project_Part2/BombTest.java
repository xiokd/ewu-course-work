package cs350s21project.bomb;

import cs350s21project.bomb.Bomb.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BombTest {

	@Test
	void testWind() {
		Bomb b = new Bomb(0, 0, 0, 0, null, 0, 45, 10);
		double dir = b.getWindDirection();
		double speed = b.getWindSpeed();
		assertEquals(45, dir);
		assertEquals(10, speed);
	}
	@Test
	void testRelease() {
		Bomb b = new Bomb(100, 200, 300, 10, null, 0, 0, 0);
		Coordinates releasepoint = b.getReleaseCoordinates();
		double speed = b.getDescentSpeed();
		double x = releasepoint.getX();
		double y = releasepoint.getY();
		double altitude = b.getReleaseAltitude();
		assertEquals(100, x);
		assertEquals(200, y);
		assertEquals(300, altitude);
		assertEquals(10, speed);
	}
	@Test
	void testError() {
		Bomb testBomb1 = new Bomb(0.0, 0.0, 0.0, 0.0, E_ErrorType.NONE, 10.0, 0.0, 0.0);
        Bomb testBomb2 = new Bomb(0.0, 0.0, 0.0, 0.0, E_ErrorType.GAUSSIAN, 10.0, 0.0, 0.0);
        Bomb testBomb3 = new Bomb(0.0, 0.0, 0.0, 0.0, E_ErrorType.UNIFORM, 10.0, 0.0, 0.0);
        
        E_ErrorType errorType1 = testBomb1.getErrorType();
        E_ErrorType errorType2 = testBomb2.getErrorType();
        E_ErrorType errorType3 = testBomb3.getErrorType();
        
        double errorRange1 = testBomb1.getErrorRange();
        double errorRange2 = testBomb2.getErrorRange();
        double errorRange3 = testBomb3.getErrorRange();
        
        assertEquals(E_ErrorType.NONE, errorType1);
        assertEquals(E_ErrorType.GAUSSIAN, errorType2);
        assertEquals(E_ErrorType.UNIFORM, errorType3);
        
        assertEquals(10.0, errorRange1);
        assertEquals(10.0, errorRange2);
        assertEquals(10.0, errorRange3);
	}

}
