package challenges;

public class OrderProcessor {

    private final InformationService informationService;
    private final OrderService orderService;
    private final DistributionCenter distributionCenter;

    public OrderProcessor(final InformationService informationService, final OrderService orderService, final DistributionCenter distributionCenter) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.distributionCenter = distributionCenter;
    }

    public OrderDto processOrder(OrderRequest orderRequest) {
        boolean isSold = orderService.sell(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity());
        if(isSold) {
            informationService.sendConfirmation(orderRequest.getUser());
            distributionCenter.sendOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            System.out.println("Unable to process order.");
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}