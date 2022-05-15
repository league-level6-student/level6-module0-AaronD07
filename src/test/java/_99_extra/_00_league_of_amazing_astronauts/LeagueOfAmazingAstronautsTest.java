package _99_extra._00_league_of_amazing_astronauts;

import _99_extra._00_league_of_amazing_astronauts.LeagueOfAmazingAstronauts;
import _99_extra._00_league_of_amazing_astronauts.models.Astronaut;
import _99_extra._00_league_of_amazing_astronauts.models.Rocketship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

/*

When writing the tests, mock both the Rocketship and Astronaut for the sake of practice.
 */
class LeagueOfAmazingAstronautsTest {
    @Mock
            Rocketship ship;
    @Mock
            Astronaut astronaut;

    LeagueOfAmazingAstronauts underTest = new LeagueOfAmazingAstronauts();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new LeagueOfAmazingAstronauts();
        underTest.setRocketship(ship);
    }

    @Test
    void itShouldPrepareAstronaut() {
        //given
        when(astronaut.isTrained()).thenReturn(true);

        //when
        underTest.prepareAstronaut(astronaut);
        //then
        verify(astronaut, times(1)).train();
        verify(ship, times(1)).loadOccupant(astronaut);
    }

    @Test
    void itShouldLaunchRocket() {
        //given
        String destination = "Mars";
        int milesToDestination = 89000000;
        //when
        when(ship.isLoaded()).thenReturn(true);
        underTest.launchRocket(destination);

        //then
        verify(ship, times(1)).setDestination(destination, milesToDestination);
        verify(ship, times(1)).launch();
    }


    @Test
    void itShouldThrowWhenDestinationIsUnknown() {
        //given
        String destination = "Mars";

        when(ship.isLoaded()).thenReturn(true);
        //when
        //then

    }

    @Test
    void itShouldThrowNotLoaded() {
        //given
        String destination = "Venus";

        when(ship.isLoaded()).thenReturn(false);
        //when
        //then

    }
}