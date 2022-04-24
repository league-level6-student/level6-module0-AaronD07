package _10_white_box_testing;

import _09_intro_to_white_box_testing.models.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _10_white_box_testing.models.BakeryService;
import _10_white_box_testing.models.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MyDonutShopTest {

    MyDonutShop myDonutShop;
@Mock
BakeryService bakeryService;
@Mock
PaymentService paymentService;
@Mock
DeliveryService deliveryService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        myDonutShop = new MyDonutShop(paymentService, deliveryService, bakeryService);
    }

    @Test
    void itShouldTakeDeliveryOrder() throws Exception {
        //given
Order order = new Order("name", "7603452346", 12, 18.90, "12343234", true);
        myDonutShop.openForTheDay();
        when(bakeryService.getDonutsRemaining()).thenReturn(12);
        //when

        //then
        assertDoesNotThrow(()-> myDonutShop.takeOrder(order));
    }

    @Test
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() {
        //given
        Order order = new Order(
                "name",
                "7603452346",
                12,
                18.90,
                "12343234",
                true);
        myDonutShop.openForTheDay();
        when(bakeryService.getDonutsRemaining()).thenReturn(1);
        //when
        Throwable exceptionThrown = assertThrows(Exception.class, () -> myDonutShop.takeOrder(order));
        //then
        assertEquals(exceptionThrown.getMessage(), "Insufficient donuts remaining");
    }

    @Test
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException(){
        //given
        Order order = new Order(
                "name",
                "7603452346",
                12,
                18.90,
                "12343234",
                true);
        myDonutShop.closeForTheDay();

        //when
        Throwable exceptionThrown = assertThrows(Exception.class, () -> myDonutShop.takeOrder(order));
        //then
        assertEquals(exceptionThrown.getMessage(), "Sorry we're currently closed");
    }

}