/*
 * Copyright 2016 Filippo Engidashet.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dalol.pronounciation.api.signature;

import org.dalol.pronounciation.api.model.Callback;
import org.dalol.pronounciation.api.model.PronounciationRequest;

/**
 *
 * @author Filippo-TheAppExpert
 */
public interface PronounciationService {
    
    void getPronounciation(PronounciationRequest request, Callback callback);
}
