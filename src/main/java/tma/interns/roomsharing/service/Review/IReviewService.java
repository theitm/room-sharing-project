package tma.interns.roomsharing.service.Review;

import tma.interns.roomsharing.dto.review.ReviewDto;
import tma.interns.roomsharing.dto.review.ReviewUpDto;

import java.util.List;
import java.util.UUID;

public interface IReviewService {
    ReviewDto createReview (ReviewDto review);
    ReviewUpDto updateReview (ReviewUpDto review, UUID reviewId);
    ReviewDto getById (UUID reviewId);
    List<ReviewDto> listAll();
    boolean delete (UUID reviewId);
}
