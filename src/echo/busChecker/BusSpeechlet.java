/**
    Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with the License. A copy of the License is located at

        http://aws.amazon.com/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package minecrafthelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.twilio.sdk.TwilioRestException;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

/**
 * This sample shows how to create a Lambda function for handling Alexa Skill requests that:
 *
 * <ul>
 * <li><b>Custom slot type</b>: demonstrates using custom slot types to handle a finite set of known values</li>
 * </ul>
 * <p>
 * <h2>Examples</h2>
 * <p>
 * <b>One-shot model</b>
 * <p>
 * User: "Alexa, ask Minecraft Helper how to make paper."
 * <p>
 * Alexa:"(reads back recipe for paper)."
 */
public class BusSpeechlet implements Speechlet {
    private static final Logger log = LoggerFactory.getLogger(MinecraftSpeechlet.class);

    /**
     * The key to get the item from the intent.
     */
    

    @Override
    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException {
        log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());

        // any initialization logic goes here
    }

    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
            throws SpeechletException {
        log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());

        String speechOutput =
                "Welcome to the Bus Helper. You can ask a question like, "
                        + "How do i get from Building A to Building B";
        // If the user either does not reply to the welcome message or says
        // something that is not understood, they will be prompted again with this text.
        String repromptText = "For instructions on what you can say, please say help me.";

        // Here we are prompting the user for input
        return newAskResponse(speechOutput, repromptText);
    }

    @Override
    public SpeechletResponse onIntent(final IntentRequest request, final Session session)
            throws SpeechletException {
        log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());

        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        if ("DirectionsIntent".equals(intentName)) {
            return getDirections(intent);
        } else if ("AMAZON.HelpIntent".equals(intentName)) {
            return getHelp();
        } else if ("AMAZON.StopIntent".equals(intentName)) {
            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText("Goodbye");

            return SpeechletResponse.newTellResponse(outputSpeech);
        } else if ("AMAZON.CancelIntent".equals(intentName)) {
            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText("Goodbye");

            return SpeechletResponse.newTellResponse(outputSpeech);
        } else {
            throw new SpeechletException("Invalid Intent");
        }
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest request, final Session session)
            throws SpeechletException {
        log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());

        // any cleanup logic goes here
    }

    /**
     * Creates a {@code SpeechletResponse} for the RecipeIntent.
     *
     * @param intent
     *            intent for the request
     * @return SpeechletResponse spoken and visual response for the given intent
     */
    private SpeechletResponse getDirections(Intent intent){
        Slot placeSlot1 = intent.getSlot("Place");

        Slot placeSlot2 = intent.getSlot("PlaceTwo");

        if (placeSlot1 != null && placeSlot1.getValue() != null
            && placeSlot2 != null && placeSlot2.getValue() != null) {
            String placeName1 = placeSlot1.getValue();
            String placeName2 = placeSlot2.getValue();

            // Get the recipe for the item
            GPSBus g = new GPSBus();
            /*
            int id1 = g.getID(placeName1);
            int id2 = g.getID(placeName2);
            */
            String direction = "It worked. place one is " + placeName1 + ", place 2 is " + placeName2;
            //String direction = id1 + " " + id2;
            String time = "It takes " + " minutes to get from " + placeName1 + " to " + placeName2;
            if (g.contains(placeName1.toLowerCase()) && g.contains(placeName2.toLowerCase())) {
                // If we have the recipe, return it to the user.
                PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
                


                
                SimpleCard card = new SimpleCard();
                card.setTitle("Directions for " + placeName1 + " to " + placeName2);

                Btime t = new Btime();

                Grab b = new Grab();
                
                SmsSender sim = new SmsSender();

                //gr.getOn(gr.coor(placeName1)); // returns JSON
                //stop with shortest time 

                //gr.getOff(gr.coor(placeName2)); // returns JSON
                //stop with find shortest time
                String yo = "";
                try {
                    yo = t.whichBus(b.getOn(b.coor("Scott Hall")), b.getOff(b.coor("Livingston Student Center")));
                } catch (Throwable e){
                    yo = "Please try again or check the module.";
                }
                direction = direction + "  , " + yo + ". Directions sent to phone";
                try {
                    sim.send(placeName1.toLowerCase(), placeName2.toLowerCase());

                    //t.whichBus( , );
                    //card.setContent(direction);
                    card.setContent(yo);
                    
                } catch (TwilioRestException e) {
            
                    card.setContent("unfinished");
                }
                outputSpeech.setText(direction);
                return SpeechletResponse.newTellResponse(outputSpeech, card);
            } else {
                // We don't have a recipe, so keep the session open and ask the user for another
                // item.
                String speechOutput =
                        "I'm sorry, I currently do not know the directions for " + placeName1 + " to " + placeName2
                                + ". What else can I help with?";
                String repromptSpeech = "What else can I help with?";
                return newAskResponse(speechOutput, repromptSpeech);
            }
        } else {
            // There was no item in the intent so return the help prompt.
            return getHelp();
        }
    }

    /**
     * Creates a {@code SpeechletResponse} for the HelpIntent.
     *
     * @return SpeechletResponse spoken and visual response for the given intent
     */
    private SpeechletResponse getHelp() {
        String speechOutput =
                "You can ask questions about directions such as, "                        
                        + "How do i get from Building A to Building B";
        String repromptText =
                "You can ask a question like, "
                        + "How do i get from Building A to Building B";
        return newAskResponse(speechOutput, repromptText);
    }

    /**
     * Wrapper for creating the Ask response. The OutputSpeech and {@link Reprompt} objects are
     * created from the input strings.
     *
     * @param stringOutput
     *            the output to be spoken
     * @param repromptText
     *            the reprompt for if the user doesn't reply or is misunderstood.
     * @return SpeechletResponse the speechlet response
     */
    private SpeechletResponse newAskResponse(String stringOutput, String repromptText) {
        PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
        outputSpeech.setText(stringOutput);

        PlainTextOutputSpeech repromptOutputSpeech = new PlainTextOutputSpeech();
        repromptOutputSpeech.setText(repromptText);
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptOutputSpeech);

        return SpeechletResponse.newAskResponse(outputSpeech, reprompt);
    }
}
