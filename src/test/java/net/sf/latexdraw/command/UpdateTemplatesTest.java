package net.sf.latexdraw.command;

import io.github.interacto.jfx.test.CommandTest;
import java.util.stream.Stream;
import javafx.scene.layout.Pane;
import net.sf.latexdraw.view.svg.SVGDocumentGenerator;
import org.junit.jupiter.api.Tag;
import org.mockito.Mockito;

/**
 * Test class for the command UpdateTemplates. Generated by Interacto test-gen.
 */
@Tag("command")
class UpdateTemplatesTest extends CommandTest<UpdateTemplates> {
	Pane templatesPane;
	SVGDocumentGenerator svgGen;

	@Override
	protected Stream<Runnable> canDoFixtures() {
		return Stream.of(() -> {
			svgGen = Mockito.mock(SVGDocumentGenerator.class);
			templatesPane = Mockito.mock(Pane.class);
			cmd = new UpdateTemplates(templatesPane, svgGen, true);
		}, () -> {
			svgGen = Mockito.mock(SVGDocumentGenerator.class);
			templatesPane = Mockito.mock(Pane.class);
			cmd = new UpdateTemplates(templatesPane, svgGen, false);
		});
	}

	@Override
	protected Stream<Runnable> doCheckers() {
		return Stream.of(
			() -> Mockito.verify(svgGen, Mockito.times(1)).updateTemplates(templatesPane, true),
			() -> Mockito.verify(svgGen, Mockito.times(1)).updateTemplates(templatesPane, false));
	}
}
