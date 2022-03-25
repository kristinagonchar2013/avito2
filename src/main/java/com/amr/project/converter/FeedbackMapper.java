package com.amr.project.converter;

import com.amr.project.model.dto.FeedbackDTO;
import com.amr.project.model.entity.Feedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    Feedback feedbackDtoToFeedback(FeedbackDTO feedbackDTO);

    FeedbackDTO feedbackToFeedbackDto(Feedback feedback);
}
