package tma.interns.roomsharing.service.Review;

import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.review.ReviewDto;
import tma.interns.roomsharing.dto.review.ReviewUpDto;
import tma.interns.roomsharing.entity.ReviewEntity;
import tma.interns.roomsharing.mapper.IReviewMapper;
import tma.interns.roomsharing.repository.ReviewRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ReviewService implements IReviewService {
    private final ReviewRepository reviewRepo;
    private final IReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepo, IReviewMapper reviewMapper) {
        this.reviewRepo = reviewRepo;
        this.reviewMapper = reviewMapper;
    }

    public ReviewDto createReview(ReviewDto review) {
        review.setDate(new Date());
        ReviewEntity reviewEntity = reviewMapper.fromReDtoToReEntity(review);
        ReviewEntity returnReview = reviewRepo.save(reviewEntity);
        return reviewMapper.toReDto(returnReview);
    }

    public ReviewUpDto updateReview(ReviewUpDto reviewUp, UUID reviewId) {
        reviewUp.setDate(new Date());
        ReviewEntity reviewEntity = reviewMapper.fromReUpDtoToReEntity(reviewUp);
        reviewEntity.setReviewId(reviewId);
        ReviewEntity returnReview =reviewRepo.save(reviewEntity);
        return reviewMapper.toReUpDto(returnReview);
    }

    public ReviewDto getById(UUID reviewId) {
        ReviewEntity reviewEntity = reviewRepo.findFirstByReviewId(reviewId);
        if(reviewEntity != null){
            return reviewMapper.toReDto(reviewEntity);
        }
        return null;
    }


    public List <ReviewDto> listAll(){
        List<ReviewEntity> reviews = reviewRepo.findAll();
        if( reviews.size()>0){
            return reviewMapper.toReviewDto(reviews);
        }
        return new ArrayList<>();
    }

    @Override
    public boolean delete(UUID reviewId) {
        ReviewEntity reviewEntity=reviewRepo.findFirstByReviewId(reviewId);
        if(reviewEntity != null){
            reviewRepo.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
